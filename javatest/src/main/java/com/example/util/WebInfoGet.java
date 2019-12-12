package com.example.util;

import java.util.concurrent.*;

public class WebInfoGet {
    public static SnowFlakeWoker snowFlakeWoker=new SnowFlakeWoker(1,1);
    public static void main(String[] args){
         Long start=System.currentTimeMillis();
         //getInfoByOneThread();
         getInfoByThreads();
         Long end=System.currentTimeMillis();
         System.out.println(end-start);
    }



    public static void getInfo(){
        String httpUrl="https://www.baidu.com";
        String filePath="D:\\httpfile";
        String fileName="baidu.html";
        StringBuilder webString=WebSiteGetUtil.getWbsiteString(httpUrl,WebSiteGetUtil.GET);
        FileUtil.storageFile(filePath,fileName,webString.toString().getBytes());
    }

    public static void getInfoByOneThread(){
        String httpUrl="https://www.baidu.com/";
        String filePath="D:\\httpfile\\thread";
        String fileName="baidu.html";
        for(int i=0;i<10;i++){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            SnowFlakeWoker snowFlakeWoker=new SnowFlakeWoker(1,1);
//            String id=snowFlakeWoker.nextId()+".html";
//            WebSiteGetUtil.getWbsiteBytes(httpUrl,WebSiteGetUtil.GET,filePath,id);
        }
    }

    public static void getInfoByThreads() {
        String httpUrl="https://www.baidu.com/";
        String filePath="D:\\httpfile\\thread";
        String fileName="baidu.html";
        final CountDownLatch countDownLatch = new CountDownLatch(10);
       // final CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        for(int i=0;i<10;i++) {
            new Thread(() -> {
                System.out.println(111);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                for(int z=0;z<100;z++){
//                    String id=snowFlakeWoker.nextId()+".html";
//                    WebSiteGetUtil.getWbsiteBytes(httpUrl,WebSiteGetUtil.GET,filePath,id);
//                }

            });
        }
        try {
            countDownLatch.await();
            System.out.println("主席执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
