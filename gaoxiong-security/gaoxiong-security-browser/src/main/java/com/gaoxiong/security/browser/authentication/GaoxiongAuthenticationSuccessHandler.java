package com.gaoxiong.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaoxiong.properties.LoginType;
import com.gaoxiong.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName GaoxiongAuthenticationSuccessHandler
 * @Description 认证成功后的跳转 实现AuthenticationSuccessHandler接口
 * @date 2018/11/11 17:19
 */
//@Component(value = "gaoxiongAuthenticationSuccessHandler")
@Slf4j
public class GaoxiongAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public void onAuthenticationSuccess ( HttpServletRequest request, HttpServletResponse response, Authentication authentication ) throws IOException, ServletException {
        log.info("登录成功");

        if (LoginType.JSON.equals(securityProperties.getBrowserProperties().getLoginType())) {
            log.info("配置了json,则处理方式是自定义");
            log.info(objectMapper.writeValueAsString(authentication));
            response.setContentType("application.json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            log.info("没有自定义,则调用父类的处理方式");
            super.onAuthenticationSuccess(request,response ,authentication );
        }
    }
}
