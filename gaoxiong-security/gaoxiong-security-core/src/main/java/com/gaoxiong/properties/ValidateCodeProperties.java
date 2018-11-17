package com.gaoxiong.properties;

/**
 * @author gaoxiong
 * @ClassName ValidateCodeProperties
 * @Description TODO
 * @date 2018/11/17 22:49
 */
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage () {
        return image;
    }

    public void setImage ( ImageCodeProperties image ) {
        this.image = image;
    }
}
