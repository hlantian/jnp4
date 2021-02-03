package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.*;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/3 10:45
 */
public class InputStreamSkip {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(FileConstants.FILE_WORK_PATH + File.separator + "chrdw.txt");
            int i;
            while ((i = inputStream.read()) != -1){
                char c = (char)i;
                System.out.println("字符："+c);
                System.out.println("跳过一个字符");
                /**
                 * InputStream.skip()此方法是从输入流的当前位置往后跳过n个字符，这样这n个字符就丢失了。
                 * 当然如果你要找回，可以直接mark，并且reset当前的流位置，重新获取流就可以了。
                 */
                inputStream.skip(1);
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
