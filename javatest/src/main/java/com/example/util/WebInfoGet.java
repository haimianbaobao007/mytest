package com.example.util;

public class WebInfoGet {

    public static void main(String[] args){
          FileUtil.readFile();
    }



    public static void getInfo(){
        String httpUrl="https://www.baidu.com";
        String filePath="D:\\httpfile";
        String fileName="baidu.jpg";
        StringBuilder webString=WebSiteGetUtil.getWbsiteString(httpUrl,WebSiteGetUtil.GET);
        FileUtil.storageFile(filePath,fileName,webString.toString().getBytes());
    }

}
