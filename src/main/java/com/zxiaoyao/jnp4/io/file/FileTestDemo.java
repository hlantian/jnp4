package com.zxiaoyao.jnp4.io.file;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 8:55
 */
public class FileTestDemo {
    public static void main(String[] args) throws IOException {
        File file = new File(FileConstants.FILE_WORK_PATH+File.separator+"java.txt");
        System.out.println("length= " +file.length());
        File file1 = new File(FileConstants.FILE_WORK_PATH,"my_java");
        if(file1.exists()){
            System.out.println("删除：" +file1.getCanonicalPath() +"| " + file1.getName());
            file1.delete();
        }else {
            System.out.println("创建 "+ file1.getAbsolutePath());
            file1.mkdir();
        }
        System.out.println(file1.getName()+ " 是不是文件夹："+file1.isDirectory());
    }
}
