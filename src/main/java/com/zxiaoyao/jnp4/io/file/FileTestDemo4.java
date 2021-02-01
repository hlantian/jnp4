package com.zxiaoyao.jnp4.io.file;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.File;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 9:21
 */
public class FileTestDemo4 {
    public static void main(String[] args) {

        FileTestDemo4 demo4 = new FileTestDemo4();
        demo4.list1();
        System.out.println("---------------");
        demo4.list2();
    }

    public void list1() {
        File file = new File(FileConstants.FILE_WORK_PATH);
        String[] names = file.list();
        for (String name : names) {
            System.out.println(name);
        }

    }

    public void list2() {
        File file = new File(FileConstants.FILE_WORK_PATH);
        File[] files = file.listFiles();
        for (File f : files) {
            String filename = f.getName();
            long time = f.lastModified();
            String filetype = "";
            String len = "";
            if (f.isDirectory()) {
                filetype = "文件夾";
            }else if(f.isFile()){
                filetype = "文件";
                len = f.length()+ "字节";
            }
            StringBuilder builder = new StringBuilder();
            builder.append(filename);
            builder.append("\t\t\t");
            builder.append(filetype);
            builder.append("\t\t\t");
            builder.append(len);
            System.out.println(builder.toString());
        }
    }
}
