package com.zxiaoyao.jnp4.io.file;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 9:31
 */
public class FileTestDemo5 {
    public static void main(String[] args) {
        File file = new File(FileConstants.FILE_WORK_PATH + File.separator + "java.txt");
        System.out.println("canRead = " + file.canRead());
        System.out.println("canWriter = " + file.canWrite());
        System.out.println("isHidden = " + file.isHidden());
        System.out.println("绝对路径 = " + file.getAbsolutePath());
        try {
            System.out.println("绝对//路径 = " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("文件名称 = " + file.getName());
        System.out.println("文件目录 = " + file.getParent());
        System.out.println("getPath " + file.getPath());
        long time = file.lastModified();
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E HH:mm");
        String lastModifiedTime = sdf.format(date);
        System.out.println(" 最后一次修改时间 == " + lastModifiedTime);
        System.out.println(" length = " + file.length());
        System.out.println(" 文件jia？ = " + file.isDirectory());
    }
}
