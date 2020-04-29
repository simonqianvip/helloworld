package com.vv.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java 2.0版本的 锁
 *  1,取代synchronize, wait, notify
 *  2,而是用 lock, await, singal
 *  3,如果用if判断变量则会出现虚假唤醒问题，防止虚假唤醒必须用while
 *  4,
 */
class AirCondition{
    private int number =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 增加
     * @throws InterruptedException
     */
    public void increase() throws InterruptedException {
        lock.lock();
        while (number != 0){
            condition.await();
        }
        number++;
        condition.signalAll();
        System.out.println(Thread.currentThread().getName() +"\t"+number);
        lock.unlock();
    }

    /**
     * 减少
     * @throws InterruptedException
     */
    public void decrease() throws InterruptedException {
        lock.lock();
        while (number == 0){
            condition.await();
        }
        number--;
        condition.signalAll();
        System.out.println(Thread.currentThread().getName() +"\t"+number);
        lock.unlock();
    }
}

public class TranditionLockDemo2 {

    public static void main(String[] args) {
        AirCondition ac = new AirCondition();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    ac.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    ac.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    ac.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    ac.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();

    }
}
