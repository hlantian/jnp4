package com.zxiaoyao.jnp4.io;

import java.io.*;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/1/29 16:44
 */
public class FileOutputStreamCopy {

    public static void main(String[] args) throws IOException {
        String workPath = System.getProperty("user.dir");
        System.out.println("workPath = " + workPath);
        String filesPath = workPath + File.separator + "files";

        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(filesPath+ File.separator + "java.txt");
            out = new FileOutputStream(filesPath + File.separator +"my_java.txt");
            while ((b = in.read()) != -1){
                out.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到文件");
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件复制错误");
            System.exit(-1);
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in != null){
                in.close();
            }
        }
    }
}
