package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
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

    }

    public void test() {
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] tt = new byte[1024];
            while (is.available() != 0){
                for(int i =0;i <1024;i++){
                    tt[i] = (byte)is.read();
                }
            }
            System.out.println(new String(tt));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(is);
        }

    }

    public void test2(){
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] bytes = new byte[1024];
            int b;
            while((b = is.read(bytes)) != -1){
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(is);
        }

    }

    public void test3(){
        InputStream is = null;
        try {
            is = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            byte[] bytes = new byte[is.available()];
            int b;
            while((b = is.read(bytes,0,bytes.length)) != -1){
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(is);
        }
    }
}
