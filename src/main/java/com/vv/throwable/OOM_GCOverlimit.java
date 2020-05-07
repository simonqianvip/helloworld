package com.vv.throwable;

import java.util.ArrayList;

/**
 * @author simon
 * @date 5/7/2020
 * -Xms1m -Xmx1m -XX:+PrintGCDetails
 */
public class OOM_GCOverlimit {
    public static void main(String[] args) {
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println(i);
        }
    }
}
