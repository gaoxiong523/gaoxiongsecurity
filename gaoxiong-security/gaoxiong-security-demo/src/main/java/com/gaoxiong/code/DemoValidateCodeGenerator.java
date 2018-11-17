package com.gaoxiong.code;

import com.gaoxiong.validate.code.ImageCode;
import com.gaoxiong.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gaoxiong
 * @ClassName DemoValidateCodeGenerator
 * @Description TODO
 * @date 2018/11/18 0:39
 */
@Component("imageCodeGenerator")
public class DemoValidateCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode createImageCode ( HttpServletRequest request ) {
        System.out.println("自动以验证码生成逻辑");
        return null;
    }
}
