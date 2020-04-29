package com.vv.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁按照指定的顺序执行线程
 *  A -> B -> C
 *  lock的通知唤醒机制
 */
class PrintNumber{
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

//    信号标识
    private int number = 0;

    public void print5(){
        lock.lock();
        while (number!= 0){//不管调哪个方法，始终是第一个执行的方法
            try {
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <= 5; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        number = 1;
//        唤醒等待线程2
        c2.signal();
        lock.unlock();
    }

    public void print10(){
        lock.lock();
        while (number!= 1){//必须等待print5执行完成
            try {
                c2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <= 10; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        number = 2;
//        唤醒等待线程3
        c3.signal();
        lock.unlock();
    }
    public void print15(){
        lock.lock();
        while (number!= 2){//必须等待print10执行完成
            try {
                c3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <= 15; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        number = 0;
//        唤醒等待线程1
        c1.signal();
        lock.unlock();
    }
}

public class LockSignDemo {
    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                pn.print5();
            }
        },"AA").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                pn.print10();
            }
        },"BB").start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                pn.print15();
            }
        },"CC").start();

    }
}
