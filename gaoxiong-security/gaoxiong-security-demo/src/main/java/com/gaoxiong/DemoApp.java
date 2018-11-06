package com.gaoxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gaoxiong
 * @ClassName com.gaoxiong.DemoApp
 * @Description TODO
 * @date 2018/10/23 0:49
 */
@SpringBootApplication
@EnableSwagger2
@EnableWebSecurity(debug = true)
public class DemoApp {
    public static void main ( String[] args ) {
        SpringApplication.run(DemoApp.class,args);
    }
}
