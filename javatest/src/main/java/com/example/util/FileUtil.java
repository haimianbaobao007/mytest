package com.example.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * 储存文件
     * @param filePath 文件目录
     * @param fileName 文件名
     * @param bytes 文件字节码
     */
    public static void storageFile(String filePath, String fileName, byte[] bytes)  {
        try {
            File direct = new File(filePath);
            if(!direct.isDirectory()){
                direct.mkdirs();
            }
            File file=new File(new File(filePath),fileName);
            if(!file.exists()){
                    // 创建文件
                    file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(){

        try {
            String filePath="D:\\httpfile\\img.jpg";
            String outPath="D:\\httpfile\\imgtext.jpg";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(outPath);
            int a=0;
            StringBuilder stringBuilder= new StringBuilder();
            while ((a=fileInputStream.read())!=-1){
                fileOutputStream.write(a);
                System.out.println(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
