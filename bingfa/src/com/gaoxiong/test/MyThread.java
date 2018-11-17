package com.gaoxiong.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaoxiong
 * @ClassName MyThread
 * @Description
 * @date 2018/11/15 17:44
 */
public class MyThread implements Runnable {
    private LockObject lockObject;
    private int printNum ;

    public MyThread ( LockObject lockObject, int printNum ) {
        this.lockObject = lockObject;
        this.printNum = printNum;
    }

    @Override
    public void run () {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        while (lockObject.orderNum <= lockObject.maxValue) {
                if (lockObject.orderNum == printNum) {
                    System.out.println(printNum);
                    lockObject.orderNum++;
                    if (lockObject.orderNum == 10) {
                        System.out.println("打印结束");
                    }
//                    lockObject.notifyAll();
                    lock.unlock();
                }
            }

    }
}
