package com.example.util;

import java.util.function.Consumer;

public class Lambda {
     private String msg;
     private static String staticmsg;


     public void test(String x) {
         Consumer<String> consumer = System.out::println;
         consumer.accept("新增数据");
     }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getStaticmsg() {
        return staticmsg;
    }

    public static void setStaticmsg(String staticmsg) {
        Lambda.staticmsg = staticmsg;
    }
}
