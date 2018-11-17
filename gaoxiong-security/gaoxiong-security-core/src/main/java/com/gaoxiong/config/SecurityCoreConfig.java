package com.gaoxiong.config;

import com.gaoxiong.properties.BrowserProperties;
import com.gaoxiong.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxiong
 * @ClassName SecurityCoreConfig
 * @Description TODO
 * @date 2018/11/10 23:03
 */
@Configuration
@EnableConfigurationProperties({SecurityProperties.class})
public class SecurityCoreConfig {
}
