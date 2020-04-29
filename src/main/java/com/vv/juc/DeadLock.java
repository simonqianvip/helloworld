package com.vv.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author simon
 * @date 4/29/2020
 * 死锁例子
 *  通过
 *      jps -l 获取死锁 pid
 *      jstack pid  查看死锁信息
 *
 */
class ThreadLock implements Runnable{
    private String lock1;
    private String lock2;

    public ThreadLock(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() +"\t lock1");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+"\t lock2");
            }
        }

    }
}

public class DeadLock {
    public static void main(String[] args) {
        String lock1 = "lockA";
        String lock2 = "lockB";
        new Thread(new ThreadLock(lock1,lock2),"AA").start();
        new Thread(new ThreadLock(lock2,lock1),"BB").start();

    }
}
