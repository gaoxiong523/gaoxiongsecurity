package com.gaoxiong.validate.code;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
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

    @GetMapping("/code/image")
    public void createCode( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        //.1.生成
        ImageCode imageCode = createImageCode(request);
        //2.放入session
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        //3.写入响应中
        ImageIO.write(imageCode.getImage(),"jpeg" ,response.getOutputStream() );

    }

    private ImageCode createImageCode ( HttpServletRequest request ) {
        int width = 67;
        int height = 23;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200,250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20 ));
        g.setColor(getRandColor(160,200));
        for (int i = 0;i<155 ; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand,13*i+6 , 16);
        }
        g.dispose();
        return new ImageCode(image,sRand ,60 );
    }
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
