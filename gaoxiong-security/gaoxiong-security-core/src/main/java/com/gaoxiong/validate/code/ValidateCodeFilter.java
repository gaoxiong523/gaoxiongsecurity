package com.gaoxiong.validate.code;

import com.gaoxiong.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * @author gaoxiong
 * @ClassName ValidateCodeFilter
 * @Description 验证码过滤器
 * @date 2018/11/11 23:33
 */
public class ValidateCodeFilter extends OncePerRequestFilter  {
    private AuthenticationFailureHandler authenticationFailureHandler;
    private SecurityProperties securityProperties;
    private Set<String> urls;
    private AntPathMatcher pathMatcher = new AntPathMatcher();


    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Override
    protected void doFilterInternal ( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
        boolean action = false;
        for (String url : urls) {
            if (pathMatcher.match(url, request.getRequestURI())) {
                action = true;
            }
        }
        if (action) {
            //如果调用的是登陆的处理器,且是post方法,过滤器 进来处理
            try {
                //校验验证码
                validateCode(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {//捕获验证码错误的异常
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        //否则的话,放行
        filterChain.doFilter(request,response );
    }

    private void validateCode ( ServletWebRequest request ) throws ServletRequestBindingException {
        //放入session中的code
        ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
        //用户输入的验证码
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        if (codeInSession.isExpired()) {
            //如果验证码过期,则需要从session中移除验证码
            sessionStrategy.removeAttribute(request,ValidateCodeController.SESSION_KEY );
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配") ;
        }
        //验证成功,使命完成,移除
        sessionStrategy.removeAttribute(request,ValidateCodeController.SESSION_KEY );
    }





    public AuthenticationFailureHandler getAuthenticationFailureHandler () {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler ( AuthenticationFailureHandler authenticationFailureHandler ) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public SecurityProperties getSecurityProperties () {
        return securityProperties;
    }

    public void setSecurityProperties ( SecurityProperties securityProperties ) {
        this.securityProperties = securityProperties;
    }

    public void setUrls ( Set<String> urls ) {
        this.urls = urls;
    }
}
