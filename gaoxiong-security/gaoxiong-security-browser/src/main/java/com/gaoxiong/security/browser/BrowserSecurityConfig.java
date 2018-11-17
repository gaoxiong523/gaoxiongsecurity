package com.gaoxiong.security.browser;

import com.gaoxiong.properties.SecurityProperties;
import com.gaoxiong.security.browser.authentication.GaoxiongAuthenticationFailHandler;
import com.gaoxiong.security.browser.authentication.GaoxiongAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author gaoxiong
 * @ClassName BrowserSecurityConfig
 * @Description
 * @date 2018/11/5 22:58
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
//    @Autowired
//    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure ( HttpSecurity http ) throws Exception {
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/template/login.html","/code/image",securityProperties.getBrowserProperties().getLoginPage())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().
                disable();

    }

    @Override
    public UserDetailsService userDetailsServiceBean () throws Exception {
        return new MyUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new GaoxiongAuthenticationSuccessHandler();
    }
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler(){
        return new GaoxiongAuthenticationFailHandler();
    }

}
