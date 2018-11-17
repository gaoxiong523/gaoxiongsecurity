package com.gaoxiong.test;

/**
 * @author gaoxiong
 * @ClassName MainTest
 * @Description TODO
 * @date 2018/11/6 14:49
 */
public class MainTest {

    public static void main ( String[] args ) {
        LockObject lockObject = new LockObject(0);
        MyThread[] ms = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            ms[i]= new MyThread(lockObject, i);
            ms[i].run();
        }
    }
}
