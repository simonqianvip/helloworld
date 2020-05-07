package com.vv.throwable;

/**
 * @author simon
 * @date 5/7/2020
 * 抛出java.lang.StackOverFlowError
 *  死循环或者递归调用会引起stackOverFlowError
 */
public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        myStackOverFlowError();
    }

    private static void myStackOverFlowError() {
        myStackOverFlowError();
    }
}
