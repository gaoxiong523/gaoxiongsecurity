package com.gaoxiong.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gaoxiong
 * @ClassName BrowserProperties
 * @Description TODO
 * @date 2018/11/10 22:58
 */
public class BrowserProperties {

    private String loginPage = "/template/login.html";

    private LoginType loginType = LoginType.JSON;

    public LoginType getLoginType () {
        return loginType;
    }

    public void setLoginType ( LoginType loginType ) {
        this.loginType = loginType;
    }

    public String getLoginPage () {
        return loginPage;
    }

    public void setLoginPage ( String loginPage ) {
        this.loginPage = loginPage;
    }
}
