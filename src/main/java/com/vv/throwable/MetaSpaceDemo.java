package com.vv.throwable;

/**
 * @author simon
 * @date 5/8/2020
 * MetaSpace 使用的是java堆外内存，不是使用的java虚拟机内存
 * -jvm参数
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *
 * jdk 1.8后，永久代被元空间给取代了
 *
 * 元空间存放的信息
 * 虚拟机加载的信息
 * 常量池
 * 静态变量
 *
 *
 */
public class MetaSpaceDemo {
    static class MetaSpace{}
    public static void main(String[] args) {
        while (true){
            try {
                MetaSpace space = new MetaSpace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
