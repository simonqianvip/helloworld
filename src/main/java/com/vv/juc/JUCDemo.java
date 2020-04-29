package com.vv.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class JUCDemo {
    public static void main(String[] args) {
        /**
         * arrayList 线程不安全
         * 1, new vector
         * 2, Collections.synchronizedList(new ArrayList<>());
         * 3, new CopyOnWriteArrayList<>();
         *
         */
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
