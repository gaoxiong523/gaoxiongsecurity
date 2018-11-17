package com.gaoxiong.validate.code;

import com.gaoxiong.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author gaoxiong
 * @ClassName ValidateCodeController
 * @Description 验证码restful
 * @date 2018/11/11 22:57
 */
@RestController
public class ValidateCodeController {

    /**
     * 图片验证码在session中的key
     */
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    /**
     * 处理session的工具
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;


    @GetMapping("/code/image")
    public void createCode( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        //.1.生成
        ImageCode imageCode = imageCodeGenerator.createImageCode(request);
        //2.放入session
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        //3.写入响应中
        ImageIO.write(imageCode.getImage(),"jpeg" ,response.getOutputStream() );

    }


}
