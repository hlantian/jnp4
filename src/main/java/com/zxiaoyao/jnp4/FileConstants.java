package com.zxiaoyao.jnp4;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 8:57
 */
public class FileConstants {
    public static final String FILE_WORK_PATH = System.getProperty("user.dir") + File.separator + "files";

    public static void close(Closeable closeable) {
        if(closeable != null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
