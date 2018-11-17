package com.gaoxiong.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author gaoxiong
 * @ClassName ValidateCodeException
 * @Description 验证码的异常
 * @date 2018/11/11 23:44
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 977144411776752045L;

    public ValidateCodeException ( String msg ) {
        super(msg);
    }
}
