package com.vv.ref;

import java.lang.ref.WeakReference;

/**
 * @author simon
 * @date 5/7/2020
 * 弱引用：只要进行了GC，就是回收全部对象
 */
public class WeakRefDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());

    }
}
