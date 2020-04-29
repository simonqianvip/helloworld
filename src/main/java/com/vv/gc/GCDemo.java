package com.vv.gc;

import java.util.concurrent.TimeUnit;

/**
 * @author simon
 * @date 4/29/2020
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("print GC detail");
        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
