package com.vv.ref;

import java.lang.ref.SoftReference;

/**
 * @author simon
 * @date 5/7/2020
 * 软引用会在内存不足时，进行垃圾回收
 */
public class SoftRefDemo {
    public static void main(String[] args) {
        soft_ref_not_enough();
    }

    /**
     * -Xms5M -Xmx5M -XX:+PrintGCDetails
     */
    public static void soft_ref_not_enough(){
        Object o1 = new Object();
        SoftReference<Object> osr = new SoftReference<>(o1);

        o1 = null;

        System.out.println(o1);
        System.out.println(osr.get());

        try{
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch(Exception e){

            e.printStackTrace();
        }finally{
            System.out.println(o1);
            System.out.println(osr.get());
        }



    }
}
