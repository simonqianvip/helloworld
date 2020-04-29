package com.vv.gc;

/**
 * @author simon
 * @date 4/29/2020
 */
public class GcDemo2 {
    public static void main(String[] args) {
//        默认机器内存的1/64
        long totalMemory = Runtime.getRuntime().totalMemory();
//        默认机器内存的1/4
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.printf("totoleMemory = %d M",totalMemory/1024/1024);
        System.out.println();
        System.out.printf("maxMemory = %d M",maxMemory/1024/1024);
    }
}
