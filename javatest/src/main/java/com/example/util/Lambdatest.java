package com.example.util;

import java.util.Arrays;
import java.util.List;

public class Lambdatest {
     public static void main(String[] args) {
          test();
     }


     public static void test(){
          LambdaTestInterface<String> lambdaTestInterface=System.out::println;
          lambdaTestInterface.dofunction("dofunction");

     }


}

class dog {


}
