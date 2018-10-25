package com.gaoxiong.exception;

/**
 * @author gaoxiong
 * @ClassName UserNotExistException
 * @Description TODO
 * @date 2018/10/25 22:48
 */
public class UserNotExistException extends RuntimeException {
    private String id;
    public UserNotExistException (String id) {
        super("user not exist");
        this.id=id;
    }

    public String getId () {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }
}
