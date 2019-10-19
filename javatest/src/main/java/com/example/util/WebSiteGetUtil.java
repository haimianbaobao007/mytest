package com.example.util;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.*;

public class WebSiteGetUtil {
    public final static String GET="GET";
    public final static String POST="POST";


    public static void main(String[] args){
         getWbsiteString("https://www.baidu.com/",WebSiteGetUtil.GET);
    }

     public static StringBuilder getWbsiteString(String httpUrl,String Method) {
         StringBuilder stringBuilder = new StringBuilder();
         HttpURLConnection httpURLConnection=null;
         URLConnection urlConnection=null;
         InputStream inputStream=null;
         BufferedReader bf=null;
         try {
             URL url = new URL(httpUrl);
             httpURLConnection= (HttpURLConnection)url.openConnection();
             httpURLConnection.setRequestMethod("GET");
             httpURLConnection.setConnectTimeout(15000);
             httpURLConnection.setReadTimeout(60000);
             httpURLConnection.connect();
             if(httpURLConnection.getResponseCode()==200){
                 inputStream=httpURLConnection.getInputStream();
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





}
