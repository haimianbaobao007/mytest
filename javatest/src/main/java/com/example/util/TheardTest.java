package com.example.util;


import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class TheardTest {
    public static void main(String[] args) {
        testList();
        //showJvm();
    }

    public static void showJvm() {
        Consumer<Long> consumer = System.out::println;
        consumer.accept(Runtime.getRuntime().maxMemory() / 1024 / 1024);  //最大可用内存，对应-Xmx
        consumer.accept(Runtime.getRuntime().freeMemory() / 1024 / 1024);   //当前JVM空闲内存
        consumer.accept(Runtime.getRuntime().totalMemory() / 1024 / 1024);
    }


    public static void testList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            list.add(2);
        }
        long startTime1 = System.currentTimeMillis();
        addOne(list);
        long endTime1 = System.currentTimeMillis();
        System.out.println("add One:"+(endTime1 - startTime1));
//        long startTime = System.currentTimeMillis();
//        addTwo(list);
//        long endTime = System.currentTimeMillis();
//        System.out.println("add Two:"+(endTime - startTime));
    }


    public static void addOne(List<Integer> list) {
        int count = 0;
        for (Integer i : list) {
            count +=doit();
        }
        System.out.println(count);
    }


    public static AtomicInteger sum=new AtomicInteger(0);
    public static void addTwo(List<Integer> list){
        Map<Integer, List<Integer>> map = batchList(list, 100000);
             int num = 1;
             List list1=new ArrayList();
             List<Thread> threadList = new ArrayList<Thread>();
            for (List<Integer> valuesList : map.values()) {
               Thread thread= new Thread(new Runnable() {
                   @Override
                   public void run() {
                       int count=0;
                       for (Integer i : valuesList) {
                           count += doit();
                       }
                       sum.addAndGet(count);
                   }
               });
               threadList.add(thread);
               thread.start();
               num++;
            }
            for(Thread thread:threadList){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
    }


    /**
     * 分割list
     *
     * @param list
     * @param cutNum
     * @return
     */
    public static <T> Map<Integer, List<T>> batchList(List<T> list, Integer cutNum) {
        Map<Integer, List<T>> listMap = new HashMap<Integer, List<T>>();
        listMap.put(1, new ArrayList<T>());
        for (T t : list) {
            List<T> batchList = listMap.get(listMap.size());
            if (cutNum == batchList.size()) {
                batchList = new ArrayList<T>();
                listMap.put(listMap.size() + 1, batchList);
            }
            batchList.add(t);
        }
        return listMap;
    }



    private static int doit(){
        String str="";
        for(int i=0;i<=200;i++){
            str+=(char)i;
        }
        return 1;
    }
}
