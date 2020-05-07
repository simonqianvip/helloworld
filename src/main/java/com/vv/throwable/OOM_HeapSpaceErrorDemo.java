package com.vv.throwable;

/**
 * @author simon
 * @date 5/7/2020
 * java.lang.OutOfMemoryError: Java heap space
 * 创建的对象超过堆得大小
 * -Xms10m -Xmx10m
 */
public class OOM_HeapSpaceErrorDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[100 * 1024 * 1024];
    }
}
