package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.*;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 9:42
 */
public class IOinTest {
    public static void main(String[] args) {
        String filePath = FileConstants.FILE_WORK_PATH + File.separator + "java.txt";
        IOinTest test = new IOinTest();
        String[] fileContent = test.readToString(filePath);
        for (String c : fileContent) {
            System.out.println(c);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        test.read2();
    }

    private String[] readToString(String filePath) {
        File file = new File(filePath);
        Long length = file.length();
        byte[] fileContent = new byte[length.intValue()];
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            in.read(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(in);
        }

        String[] fileContentArr = new String(fileContent).split("\r\n");
        return fileContentArr;
    }

    public void read2() {
        String filePath = FileConstants.FILE_WORK_PATH + File.separator + "java.txt";
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            byte[] b = new byte[1024];
            int len = 0;
            int temp = 0;
            while ((temp = in.read()) != -1) {
                if (len == 1024) {
                    len = 0;
                }
                b[len++] = (byte) temp;
            }
            System.out.println(new String(b, 0, len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(in);
        }


    }
}
