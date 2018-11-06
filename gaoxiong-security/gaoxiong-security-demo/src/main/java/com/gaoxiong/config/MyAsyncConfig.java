package com.gaoxiong.config;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gaoxiong
 * @ClassName MyAsyncConfig
 * @Description 异步的线程池都是需要单独配置
 * @date 2018/11/4 21:36
 */
public class MyAsyncConfig implements WebMvcConfigurer {
    @Override
    public void configureAsyncSupport ( AsyncSupportConfigurer configurer ) {
        configurer.registerCallableInterceptors();//异步的拦截器
        configurer.registerDeferredResultInterceptors();//异步的两种拦截器
        configurer.setTaskExecutor(null);//定制可用的线程池
    }
}
