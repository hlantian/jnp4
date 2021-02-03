package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/3 10:14
 */
public class IOinTest6 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            System.out.println("len = " + inputStream.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }
    }
}
