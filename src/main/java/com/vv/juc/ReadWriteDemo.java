package com.vv.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 example
 * 利用volatile实现集合容器的可见性和禁用指令重排
 * 利用ReentrantReadWriteLock实现读写分离
 */
public class ReadWriteDemo {
    public volatile Map map = new HashMap<String,Object>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void put(int i ){
        rwl.writeLock().lock();
        try {
            System.out.println(i +" 开始写");
            map.put(Thread.currentThread().getName(),i+"");
            System.out.println(i +" 写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
        }
    }

    public void get(int i ){
        rwl.readLock().lock();
        try {
            System.out.println(i +" 开始读");
            map.put(Thread.currentThread().getName(),i+"");
            System.out.println(i +" 读取完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteDemo rwd = new ReadWriteDemo();

        for (int i = 0; i < 3; i++) {
            final int tempInt = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.put(tempInt);
                }
            },String.valueOf(tempInt)).start();
        }

        for (int i = 0; i < 3; i++) {
            final int tempInt = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.get(tempInt);
                }
            },String.valueOf(tempInt)).start();
        }

    }
}
