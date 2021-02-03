package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description InputStream.mark()设置输入流的当前位置 问题是  InputStream 和 FileInputStream 都不支持 此例子仅演示 没作用
 * @Author hlantian
 * @Date 2021/2/3 10:34
 */
public class InputStreamMark {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(FileConstants.JAVA_TXT_FILE_PATH);
            System.out.println("Char: " + (char)inputStream.read());
            inputStream.mark(0);// 设置流位置重新为0
            System.out.println("Char:" +(char)inputStream.read());
            if(inputStream.markSupported()){
                inputStream.reset();
                System.out.println("char:"+(char)inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(inputStream);
        }

    }
}
