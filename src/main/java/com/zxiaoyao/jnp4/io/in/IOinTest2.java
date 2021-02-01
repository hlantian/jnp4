package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.*;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 10:17
 */
public class IOinTest2 {
    public static void main(String[] args) {
        IOinTest2 test2 = new IOinTest2();
        test2.test1();
        System.out.println("-------------------------end -----------------------");
        System.out.println();
        System.out.println();
        System.out.println();

        test2.test2();

    }

    public void test1() {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = new FileInputStream(FileConstants.FILE_WORK_PATH + File.separator + "java.txt");
            fos = new FileOutputStream(FileConstants.FILE_WORK_PATH + File.separator+"file1.txt");
            byte[] b= new byte[1024];
            int len = 0;
            while ((len = is.read(b) )!= -1){
                fos.write(b,0,len);
                if(len == 1024){
                    b = new byte[1024];
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(fos);
            FileConstants.close(is);
        }

    }


    public void test2(){
        File file = new File(FileConstants.FILE_WORK_PATH+File.separator+"writer1.txt");
        Writer writer = null;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            writer = new FileWriter(file,true);
            writer.write("文件内容");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(writer);
        }
    }
}
