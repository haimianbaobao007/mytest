package com.example.util;

import javax.lang.model.element.NestingKind;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static void main(String[] args){
         String filePath="D:\\httpfile";
         String fileName="patch.txt";
         storageFile(filePath,fileName);
    }


    public static void storageFile(String filePath,String fileName)  {
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
            fileOutputStream.write(WebSiteGetUtil.getWbsiteString("https://www.baidu.com/",WebSiteGetUtil.GET).toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
