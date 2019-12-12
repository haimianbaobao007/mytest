package com.example.entity;


public class Car {
    private String brand;
    private String color;
    private int num;

    public Car(String brand, String color, int num) {
        this.brand = brand;
        this.color = color;
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
