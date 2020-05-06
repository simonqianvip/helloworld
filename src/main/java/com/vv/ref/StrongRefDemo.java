package com.vv.ref;

/**
 * @author simon
 * @date 5/6/2020
 * 强引用，无论什么情况下（包括OOM），都不会回收对象
 */
public class StrongRefDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();//创建一个引用
        Object obj2 = obj1; //对象2指向对象1的引用
        obj1 = null;

        System.gc();
        System.out.println(obj2);//只要有个一个强引用在，就不会进行垃圾回收
    }
}
