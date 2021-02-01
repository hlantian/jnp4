package com.zxiaoyao.jnp4.io.file;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 9:05
 */
public class FileTestDemo2 {

    public static void main(String[] args) {
        create1();
        create2();
        create3();
        create4();
    }

    public static void create1() {
        try {
            File dir = new File(FileConstants.FILE_WORK_PATH);
            File file = new File(dir, "file1.txt");
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void create2() {
        File file = new File(FileConstants.FILE_WORK_PATH, "file2.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create3() {
        File file = new File(FileConstants.FILE_WORK_PATH + File.separator + "file3.txt0");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create4() {
        try {
            URI uri = new URI("file:/workspace/jnp4/files/file4.txt");
            File file = new File(uri);
            file.createNewFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
