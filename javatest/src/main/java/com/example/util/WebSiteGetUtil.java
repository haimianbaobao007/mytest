package com.example.util;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.*;

public class WebSiteGetUtil {
    public final static String GET="GET";
    public final static String POST="POST";



     public static StringBuilder getWbsiteString(String httpUrl,String Method) {
         StringBuilder stringBuilder = new StringBuilder();
         HttpURLConnection httpURLConnection=null;
         InputStream inputStream=null;
         BufferedReader bf=null;
         try {
             URL url = new URL(httpUrl);
             httpURLConnection= (HttpURLConnection)url.openConnection();
             httpURLConnection.setRequestMethod("GET");
             httpURLConnection.setConnectTimeout(15000);
             httpURLConnection.setReadTimeout(60000);
             httpURLConnection.connect();
             inputStream=httpURLConnection.getInputStream();
             if(httpURLConnection.getResponseCode()==200){
                 bf=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                 String temp=null;
                 while ((temp=bf.readLine())!=null){
                     stringBuilder.append(temp);
                 }
                 // 关闭流
                 if(inputStream!=null) {
                     inputStream.close();
                 }
                 if(bf!=null){
                     bf.close();
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return stringBuilder;
     }



    public static void getWbsiteBytes(String httpUrl,String Method,String fileUrl,String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        InputStreamReader inputStreamReader = null;
        try {
            URL url = new URL(httpUrl);
            httpURLConnection= (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.connect();
            inputStream=httpURLConnection.getInputStream();
            FileUtil.createFile(fileUrl,fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileUrl+"\\"+fileName);
            if(httpURLConnection.getResponseCode()==200){
                byte[] bytes=new byte[1024];
                while (inputStream.read(bytes)!=-1){
                       fileOutputStream.write(bytes);
                }
                // 关闭流
                if(inputStream!=null) {
                    inputStream.close();
                }
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
