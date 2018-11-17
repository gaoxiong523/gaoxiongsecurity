package com.gaoxiong.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoxiong.properties.LoginType;
import com.gaoxiong.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName GaoxiongAuthenticationFailHandler
 * @Description 登陆失败的处理器
 * @date 2018/11/11 17:54
 */
@Slf4j
public class GaoxiongAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public void onAuthenticationFailure ( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException {
        log.error("登录失败");
        if (LoginType.JSON.equals(securityProperties.getBrowserProperties().getLoginType())) {
            log.error(objectMapper.writeValueAsString(exception));
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application.json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
