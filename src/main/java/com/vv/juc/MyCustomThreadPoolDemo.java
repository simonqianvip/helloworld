package com.vv.juc;

import java.util.concurrent.*;

/**
 * @author simon
 * @date 4/28/2020
 * 利用ThreadPoolExcutor创建线程池,自定义阻塞队列的大小
 *  4种拒绝策略
 *      1）AbortPolicy()   超过线程池的maxCore + queue，直接抛异常
 *      2）CallerRunsPolicy()    超过线程池的maxCore + queue，把任务返回给主线程
 *      3）DiscardOldestPolicy   超过线程池的maxCore + queue，抛弃最老的任务
 *      4）DiscardPolicy     超过线程池的maxCore + queue，抛弃最新的任务
 */
public class MyCustomThreadPoolDemo {
    public static void main(String[] args) {
//        创建线程池
        ExecutorService poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try{
            for (int i = 0; i < 10; i++) {
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t售票");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            poolExecutor.shutdown();
        }
    }
}
