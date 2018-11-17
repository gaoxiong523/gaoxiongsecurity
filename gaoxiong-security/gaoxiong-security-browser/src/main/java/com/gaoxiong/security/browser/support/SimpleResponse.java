package com.gaoxiong.security.browser.support;

import lombok.Data;

/**
 * @author gaoxiong
 * @ClassName SimpleResponse
 * @Description 简单的返回信息封装
 * @date 2018/11/10 22:45
 */
@Data
public class SimpleResponse {

    private Object object;

    public SimpleResponse ( Object object ) {
        this.object = object;
    }
}
