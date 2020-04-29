package com.vv.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 *  1、队列空的，获取阻塞（消费者阻塞）
 *  2、队列满的、写入阻塞（生产者阻塞）
 */
public class BlockQueueDemo {
    public static void main(String[] args) {
        BlockingQueue bq = new ArrayBlockingQueue<String>(3);

        System.out.println(bq.add("a"));
        System.out.println(bq.add("b"));
        System.out.println(bq.add("c"));
    }
}
