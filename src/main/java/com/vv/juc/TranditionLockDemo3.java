package com.vv.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * juc 3.0
 *  volitile/CAS/BlockQueue/AtomicInteger/线程交互
 */
class MySource{
    private AtomicInteger ai = new AtomicInteger();
    public BlockingQueue<String> blockingQueue = null;
    private volatile boolean flag = true;

    public MySource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce(BlockingQueue blockingQueue) throws InterruptedException {
        String data = null;
        while (flag){
            data = ai.incrementAndGet() +"";
//            插入数据
            boolean f = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(f){
                System.out.println(Thread.currentThread().getName() +"\t插入"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName() +"\t插入"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("生产者退出");
    }

    public void consumer(BlockingQueue blockingQueue) throws InterruptedException {
        String data = "null";
        while (flag){
            data = String.valueOf(blockingQueue.poll(2L, TimeUnit.SECONDS));
            if("null" == data  || data.equalsIgnoreCase("null")){
                System.out.println(Thread.currentThread().getName() +"\t队列没有数据了，消费者退出");
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() +"\t取出"+data+"成功");

//            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("消费者退出");
    }

    public void stop(){
        flag = false;
    }
}
public class TranditionLockDemo3 {
    public static void main(String[] args) {
        MySource ms = new MySource(new ArrayBlockingQueue(3));
        new Thread(() ->{
            try {
                ms.produce(ms.blockingQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(() -> {
            try {
                ms.consumer(ms.blockingQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ms.stop();
        System.out.println("老板说下班！！！");

    }
}
