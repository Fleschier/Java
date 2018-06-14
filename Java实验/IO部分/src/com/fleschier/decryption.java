package com.fleschier;

import java.io.*;
import java.util.Scanner;

public class decryption {

    public static void main(String[] args) throws Exception {

        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(new File("EncryptedFile.txt")));

        BufferedOutputStream output = new BufferedOutputStream(
                new FileOutputStream(new File("result.txt")));

        int value;
        while ((value = in.read()) != -1) { //当读到的不是文件尾时，则循环继续
            output.write(value - 5);
        }

        in.close();
        output.close();
    }


}

//今天遇到一个很奇怪的问题，就是自己写文件读取的时候，始终抛出异常，java.io.FileNotFoundException，找了很多教程也不知道是怎么回事。