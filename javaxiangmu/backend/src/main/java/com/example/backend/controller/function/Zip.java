package com.example.backend.controller.function;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Zip{

    public static String getstr() throws IOException {
        String str1="";
        double num=0;
        //获取文件输入流
        FileInputStream input = new FileInputStream("C:\\Users\\lsewcx\\Desktop\\javaxiangmu.zip");

        //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));

        //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
        ZipEntry ze = null;

        //循环遍历
        while ((ze = zipInputStream.getNextEntry()) != null) {


            //读取
            BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream,Charset.forName("UTF-8")));

            String line;

            //内容不为空，输出
            while ((line = br.readLine()) != null) {
                str1+=line;
            }
        }

        //一定记得关闭流
        zipInputStream.closeEntry();
        input.close();
        return str1;
    }

    public static String getstr1() throws IOException {
        String str1="";
        //获取文件输入流
        FileInputStream input = new FileInputStream("C:\\Users\\lsewcx\\Desktop\\javaxiangmu1.zip");

        //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));

        //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
        ZipEntry ze = null;

        //循环遍历
        while ((ze = zipInputStream.getNextEntry()) != null) {


            //读取
            BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream,Charset.forName("GBK")));

            String line;

            //内容不为空，输出
            while ((line = br.readLine()) != null) {
                str1+=line;
            }
        }

        //一定记得关闭流
        zipInputStream.closeEntry();
        input.close();
        return str1;
    }


}