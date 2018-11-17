package com.gaoxiong.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author gaoxiong
 * @ClassName ImageCode
 * @Description 图形验证码
 * @date 2018/11/11 22:52
 */
public class ImageCode {

    /**
     * 图片
     */
    private BufferedImage image;

    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     *
     * @param image
     * @param code
     * @param expireIn 多少秒过期
     */
    public ImageCode ( BufferedImage image, String code, int expireIn ) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
    public ImageCode ( BufferedImage image, String code, LocalDateTime expireTime ) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }


    public BufferedImage getImage () {
        return image;
    }

    public void setImage ( BufferedImage image ) {
        this.image = image;
    }

    public String getCode () {
        return code;
    }

    public void setCode ( String code ) {
        this.code = code;
    }

    public LocalDateTime getExpireTime () {
        return expireTime;
    }

    public void setExpireTime ( LocalDateTime expireTime ) {
        this.expireTime = expireTime;
    }

    public boolean isExpired () {

        if (LocalDateTime.now().isAfter(this.expireTime)) {
            return false;
        } else {
            return true;
        }
    }
}
