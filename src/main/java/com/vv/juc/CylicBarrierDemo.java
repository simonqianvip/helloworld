package com.vv.juc;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 累加功能：
 *  1）等待线程全部执行完成，再执行
 */
public class CylicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(7,() -> {
            System.out.println(">>>>>> 集齐龙珠 <<<<<<");
        });

        for (int i = 0; i < 7; i++) {
            final int tempInt = i;
            new Thread(() ->{
                System.out.println("龙珠 "+tempInt+" 收到");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },tempInt+"").start();
        }

    }
}
