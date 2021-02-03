package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.*;

/**
 * @Description Java InputStream读取文件
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

    /**
     * 1. FileInputStream通过文件byte数组暂存文件中内容，将其转换为String数据，再按照 “回车换行” 进行分割。
     * @param filePath 文件的路径
     * @return 文件中一行一行的数据
     */
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

    /**
     * 使用InputStream从文件里读取数据，在已知文件大小的情况下，建立合适的存储字节数组
     */
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
