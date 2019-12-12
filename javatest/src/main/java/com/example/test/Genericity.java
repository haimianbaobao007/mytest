package com.example.test;

import java.util.function.Function;

public class Genericity<T> {


    public<R> void show(Function<? super T,? extends R> mapper){
        System.out.println(mapper);
    }
}
