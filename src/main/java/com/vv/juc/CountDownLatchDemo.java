package com.vv.juc;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch
 *  倒计时功能:只有满足条件了，才会向下执行
 *
 *  程序员分2种
 *      1，功能
 *      2，功能 + 性能
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch cdl = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +" 国，被灭");
                    cdl.countDown();
                }
            }, Country.forEach(tempInt).retName).start();
        }
        cdl.await();
        System.out.println(">>>>>>>>>>>>  秦国一统天下 <<<<<<<<<<<");
    }
}
