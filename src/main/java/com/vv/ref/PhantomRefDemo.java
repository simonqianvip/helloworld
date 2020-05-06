package com.vv.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author simon
 * @date 5/7/2020
 * 虚引用就是空的，被GC后，就会存入到队列
 */
public class PhantomRefDemo {
    public static void main(String[] args) {
        myPhantomRef();
    }

    private static void myPhantomRef() {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, queue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

        System.out.println("=======================");

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

    }
}
