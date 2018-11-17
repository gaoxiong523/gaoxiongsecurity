package com.gaoxiong.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gaoxiong
 * @ClassName SecurityProperties
 * @Description 统一属性配置
 * @date 2018/11/10 22:58
 */
@ConfigurationProperties(prefix = "gaoxiong.security")
public class SecurityProperties {

    private BrowserProperties browserProperties = new BrowserProperties();
    private ValidateCodeProperties codeProperties = new ValidateCodeProperties();
    public BrowserProperties getBrowserProperties () {
        return browserProperties;
    }

    public void setBrowserProperties ( BrowserProperties browserProperties ) {
        this.browserProperties = browserProperties;
    }

    public ValidateCodeProperties getCodeProperties () {
        return codeProperties;
    }

    public void setCodeProperties ( ValidateCodeProperties codeProperties ) {
        this.codeProperties = codeProperties;
    }
}
