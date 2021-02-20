package com.zxiaoyao.jnp4.thread;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.Date;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/4 16:22
 */
public class LogFile {

    private Writer out;

    public LogFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        this.out = new BufferedWriter(fileWriter);
    }

    public void writeEntry(String message) throws IOException {
        Date date = new Date();
        out.write(date.toString());
        out.write("\t");
        out.write(message);
        out.write("\r\n");
    }

    public void writeEntry1(String message) throws IOException {
        synchronized(out){
            Date date = new Date();
            out.write(date.toString());
            out.write("\t");
            out.write(message);
            out.write("\r\n");
        }
    }

    public void writeEntry2(String message) throws IOException {
        synchronized(this){
            Date date = new Date();
            out.write(date.toString());
            out.write("\t");
            out.write(message);
            out.write("\r\n");
        }
    }

    public synchronized void writeEntry3(String message) throws IOException {
        Date date = new Date();
        out.write(date.toString());
        out.write("\t");
        out.write(message);
        out.write("\r\n");
    }



    public void close() throws IOException {
        out.flush();
        out.close();
    }
}
