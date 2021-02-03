package com.zxiaoyao.jnp4.io.out;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/3 15:31
 */
public class OutputStreamDemo {

    public static void main(String[] args) {
        File file = new File(FileConstants.FILE_WORK_PATH + File.separator + "1.txt");
        OutputStream out = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            out.write("测试数据文字".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(out);
        }
    }
}
