package com.zxiaoyao.jnp4.thread;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 13:34
 */
public class GZipRunnable implements Runnable {

    private final File input;

    public GZipRunnable(File input) {
        this.input = input;
    }

    @Override
    public void run() {
        String fileName = input.getName();
        if (!fileName.endsWith(".gz")) {
            File output = new File(input.getParent(), fileName+ ".gz");
            if (!output.exists()) {
                try (InputStream in = new BufferedInputStream(new FileInputStream(input));
                     OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));
                ) {
                    int b;
                    while ((b = in.read()) !=-1){
                        out.write(b);
                    }
                    out.flush();
                    System.out.println("gz :" +fileName);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
