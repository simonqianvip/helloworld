package com.vv.ref;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author simon
 * @date 5/7/2020
 * weakHashMap在key对象被置位空后，系统进行GC后，该key对应的值会被删除
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("++++++++++++++++++++++++++");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> hm = new WeakHashMap<Integer, String>();
        Integer key = new Integer(1);
        hm.put(key,"hashMap");

        System.out.println(hm);

        key = null;
        System.out.println(hm);

        System.gc();
        System.out.println(hm);
    }

    private static void myHashMap() {
        HashMap<Integer, String> hm = new HashMap<>();
        Integer key = new Integer(1);
        hm.put(key,"hashMap");

        System.out.println(hm);

        key = null;
        System.out.println(hm);

        System.gc();
        System.out.println(hm);


    }
}
