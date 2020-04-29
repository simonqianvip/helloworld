package com.vv.juc;

import java.util.concurrent.Semaphore;

/**
 * 信号灯
 * 1、比countDownLatch、CylicBarrier都好
 * 2、具有伸缩性
 */
public class SemaPhoreDemo {
    public static void main(String[] args) {
        Semaphore smp = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            final int temInt = i;
            new Thread(() -> {
                try {
//                    Acquires a permit from this semaphore
                    smp.acquire();
                    System.out.println(temInt + "\t号车进来");
                    Thread.sleep(3000);
//                    Releases a permit, returning it to the semaphore.
                    smp.release();
                    System.out.println(temInt + "\t号车离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, temInt + "").start();
        }
    }
}
