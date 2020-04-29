package com.vv.juc;


import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *  1）只有等A线程释放锁之后，B线程才能释放锁
 */

public class MySpinLock {
    static AtomicReference ar = new AtomicReference<Thread>();

    public static void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() +" invoked lock");
        while (!ar.compareAndSet(null,thread)){

        }
    }

    public static void myUnLock(){
        Thread thread = Thread.currentThread();
        ar.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() +" invoked unlock");

    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                myLock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myUnLock();
            }
        },"aa").start();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                myLock();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                myUnLock();
            }
        },"bb").start();
    }
}
