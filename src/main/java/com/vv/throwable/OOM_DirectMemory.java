package com.vv.throwable;

import java.nio.ByteBuffer;

/**
 * @author simon
 * @date 5/7/2020
 * 参数配置
 * -Xms1m -Xmx1m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * java.lang.OutOfMemoryError: Direct buffer memory
 * 堆外内存溢出
 */
public class OOM_DirectMemory {
    public static void main(String[] args) {
//        堆外内存大小，机器内存的1/4
//        先查看本机的堆外内存
        System.out.printf("MaxDirectBufferMomery= %d MB",sun.misc.VM.maxDirectMemory() / 1024 /1024);
//        创建一个堆外内存为10M的对象，直接导致OOM
        ByteBuffer direct = ByteBuffer.allocateDirect(10 * 1024 * 1024);
    }
}
