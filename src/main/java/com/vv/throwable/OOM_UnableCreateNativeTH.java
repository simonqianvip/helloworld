package com.vv.throwable;

/**
 * @author simon
 * @date 5/8/2020
 * linux 默认一个进程只能创建一个1024个线程，如果超过这个设置会报
 * java.lang.OutOfMemoryError: unable to create new native thread
 */
public class OOM_UnableCreateNativeTH {
    public static void main(String[] args) {
//        循环无限次
        for (int i = 0; ; i++) {
//            System.out.println("创建"+i+"个线程");
            new Thread(()->{
                try {
//                    睡眠整型的最大时间
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
