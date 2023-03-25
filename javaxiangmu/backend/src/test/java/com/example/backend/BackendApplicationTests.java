package com.example.backend;

import com.example.backend.controller.function.gonneng;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import com.example.backend.controller.function.Zip;
@SpringBootTest
class BackendApplicationTests {//点左边的test

    @Test
    public void test()throws Exception {

        String text3=Zip.getstr();
        String text4=Zip.getstr1();
        System.out.println("文本相似度为："+ gonneng.getSimilarity(text3, text4));

    }
}
