package com.vv.juc;

/**
 * 验证volatile的可见性
 */

class MyData{
    volatile int number = 10;
    public void numberTo20(){
        this.number = 20;
    }

}

public class VolatileDemo {


    public static void main(String[] args) {
        final MyData myData = new MyData();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("number = "+myData.number);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.numberTo20();
                System.out.println("number = "+myData.number);
            }
        },"aa").start();

        while (myData.number == 10){

        }

        System.out.println("mission is over");
    }
}
