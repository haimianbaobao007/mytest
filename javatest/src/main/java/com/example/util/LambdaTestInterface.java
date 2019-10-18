package com.example.util;

@FunctionalInterface
public interface LambdaTestInterface<T> {

    void dofunction(T t);

    @Override
    boolean equals(Object obj);
}
