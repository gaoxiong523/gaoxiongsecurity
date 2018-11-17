package com.gaoxiong.validate.code;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gaoxiong
 * @ClassName ValidateCodeGenerator
 * @Description 校验码的生成接口
 * @date 2018/11/18 0:26
 */
public interface ValidateCodeGenerator {
    ImageCode createImageCode( HttpServletRequest request );
}
