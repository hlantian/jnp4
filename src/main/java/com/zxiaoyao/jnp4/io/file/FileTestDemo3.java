package com.zxiaoyao.jnp4.io.file;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 9:15
 */
public class FileTestDemo3 {

    public static void main(String[] args) {

        //1
        File dir = new File(FileConstants.FILE_WORK_PATH +File.separator+"dir");
        dir.mkdir();

        //2
        URI uri = null;
        try {
            uri = new URI("file:/workspace/jnp4/files/dir2");
            File dir2 = new File(uri);
            dir2.mkdir();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
