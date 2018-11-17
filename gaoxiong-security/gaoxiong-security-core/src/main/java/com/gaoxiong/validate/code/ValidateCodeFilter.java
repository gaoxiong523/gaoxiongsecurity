package com.gaoxiong.validate.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName ValidateCodeFilter
 * @Description 验证码过滤器
 * @date 2018/11/11 23:33
 */
public class ValidateCodeFilter extends OncePerRequestFilter {
    private AuthenticationFailureHandler authenticationFailureHandler;
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Override
    protected void doFilterInternal ( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
        if (StringUtils.equals("/authentication/form", request.getRequestURI()) && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
            //如果调用的是登陆的处理器,且是post方法,过滤器 进来处理
            try {
                //校验验证码
                validateCode(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {//捕获验证码错误的异常
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        }
        //否则的话,放行
        filterChain.doFilter(request,response );
    }

    private void validateCode ( ServletWebRequest request ) throws ServletRequestBindingException {
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        if (codeInSession.isExpired()) {
            sessionStrategy.removeAttribute(request,ValidateCodeController.SESSION_KEY );
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配") ;
        }
        sessionStrategy.removeAttribute(request,ValidateCodeController.SESSION_KEY );
    }
}
