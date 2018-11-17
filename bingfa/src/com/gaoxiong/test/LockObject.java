package com.gaoxiong.test;

/**
 * @author gaoxiong
 * @ClassName LockObject
 * @Description 锁
 * @date 2018/11/15 17:48
 */
public class LockObject {
    int orderNum = 0;
    final int maxValue = 9;
    public LockObject(int orderNum){
        this.orderNum = orderNum;
    }
}
