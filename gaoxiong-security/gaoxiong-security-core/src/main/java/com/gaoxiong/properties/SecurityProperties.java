package com.gaoxiong.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gaoxiong
 * @ClassName SecurityProperties
 * @Description TODO
 * @date 2018/11/10 22:58
 */
@ConfigurationProperties(prefix = "gaoxiong.security")
public class SecurityProperties {

    private BrowserProperties browserProperties = new BrowserProperties();

    public BrowserProperties getBrowserProperties () {
        return browserProperties;
    }

    public void setBrowserProperties ( BrowserProperties browserProperties ) {
        this.browserProperties = browserProperties;
    }


}
