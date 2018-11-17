package com.gaoxiong.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gaoxiong
 * @ClassName MyWebMvcConfig
 * @Description TODO
 * @date 2018/11/6 10:40
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers ( ViewControllerRegistry registry ) {
        registry.addViewController("/login").setViewName("/resources/template/login.html");
    }
}
