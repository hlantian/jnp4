package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.*;

/**
 * @Description Java InputStream.read()读取数据流字节，存储到缓冲区数组
 * @Author hlantian
 * @Date 2021/2/1 11:33
 */
public class IOinTest5 {
    public static void main(String[] args) {
        IOinTest5 test5 = new IOinTest5();
        test5.test();
        System.out.println("----------end-------------");
        System.out.println();
        test5.test2();
        System.out.println("----------end-------------");
        System.out.println();
        test5.test3();
        System.out.println("-----------end-------------");
        System.out.println();
        test5.test5();

    }

    public void test() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] tt = new byte[1024];
            while (is.available() != 0) {
                for (int i = 0; i < 1024; i++) {
                    tt[i] = (byte) is.read();
                }
            }
            System.out.println(new String(tt));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(is);
        }

    }

    public void test2() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] bytes = new byte[1024];
            int b;
            while ((b = is.read(bytes)) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(is);
        }

    }

    public void test3() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] bytes = new byte[is.available()];
            int b;
            while ((b = is.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(is);
        }
    }

    public void test5() {
        File file = new File(FileConstants.JAVA_TXT_FILE_PATH);
        FileInputStream inputStream=null;
        try {
            inputStream = new FileInputStream(file);
            byte[] b = new byte[(int)file.length()];
            int len = inputStream.read(b, 0, b.length);
            System.out.println(new String(b));
            System.out.println("b.length== len ? :" + (b.length == len));
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }

        try {
            inputStream = new FileInputStream(file);
            byte[] bb = new byte[1024];
            int len2 = inputStream.read(bb);
            System.out.println(new String(bb,0,len2));
            System.out.println("len2 = " + len2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }

        try {
            inputStream = new FileInputStream(file);
            byte[] bbb = new byte[(int)file.length()];
            for(int i =0;i<bbb.length;i++){
                bbb[i] = (byte)inputStream.read();
            }
            System.out.println(new String(bbb));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }
    }
}
