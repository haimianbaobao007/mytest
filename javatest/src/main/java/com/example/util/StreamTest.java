package com.example.util;

import com.example.entity.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args){
        List<Car> list = new ArrayList<Car>();
        list.add(new Car("测试1","red",4));
        list.add(new Car("测试2","yellow",2));
        list.add(new Car("测试3","blue",1));
        list.add(new Car("测试4","red",7));
        list.add(new Car("测试5","black",8));
        // 过滤
        Stream<Car> stream=list.stream().filter(e-> e.getColor().equals("red"));
        //stream.forEach(s-> System.out.println(s.getBrand()));
        List<Car> redCar=stream.collect(Collectors.toList());
        redCar.stream().forEach(System.out::println);
        System.out.println("-----------------------------------------");
        list.stream().sorted(Comparator.comparing(Car::getNum)).forEach(e->System.out.println(e.getBrand()+"->"+e.getNum()));
        System.out.println("-----------------------------------------");
        int sum=list.stream().mapToInt(Car::getNum).sum();
        System.out.println(sum);
        System.out.println("-----------------------------------------");
        String brand=list.stream().map(Car::getBrand).collect(Collectors.joining(","));
        System.out.println(brand);
    }
}
