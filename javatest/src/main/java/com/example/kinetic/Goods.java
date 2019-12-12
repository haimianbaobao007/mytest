package com.example.kinetic;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;

public class Goods {
    private BigDecimal quality;
    private BigDecimal speed;
    private BigDecimal joule;


    public Goods(@NotNull BigDecimal quality,@NotNull BigDecimal speed) {
        this.quality = quality;
        this.speed = speed;
        calculationJoule();
    }


    public void setQuality(BigDecimal quality){
        this.quality = quality;
        calculationJoule();
    }

    public void setSpeed(BigDecimal speed){
        this.quality = quality;
        calculationJoule();
    }


    private void calculationJoule(){
        this.joule=quality.multiply(speed).multiply(speed).divide(new BigDecimal(2));
    }

    public BigDecimal getQuality() {
        return quality;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public BigDecimal getJoule() {
        return joule;
    }

    public static void main(String[] args){
        Goods goods= new Goods(BigDecimal.valueOf(100000),BigDecimal.valueOf(2400));
        BigDecimal kwh=goods.getJoule().divide(BigDecimal.valueOf(3600000));
        System.out.println(kwh);
    }
}
