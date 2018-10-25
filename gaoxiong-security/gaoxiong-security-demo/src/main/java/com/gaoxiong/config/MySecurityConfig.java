package com.gaoxiong.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author gaoxiong
 * @ClassName MySecurityConfig
 * @Description TODO
 * @date 2018/10/25 1:23
 */
@Configuration//
public class MySecurityConfig implements WebSecurityConfigurer {

    @Override
    public void init ( SecurityBuilder builder ) throws Exception {

    }

    @Override
    public void configure ( SecurityBuilder builder ) throws Exception {

    }
}
