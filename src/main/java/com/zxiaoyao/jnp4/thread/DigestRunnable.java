package com.zxiaoyao.jnp4.thread;

import com.zxiaoyao.jnp4.FileConstants;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/4 13:59
 */
public class DigestRunnable implements Runnable {

    private String filename;

    public DigestRunnable(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        FileInputStream in = null;
        DigestInputStream din = null;
        try {
            in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            din = new DigestInputStream(in, sha);
            while (din.read() != -1) ;
            byte[] digest = sha.digest();
            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileConstants.close(din);
            FileConstants.close(in);
        }
    }

    public static void main(String[] args) {
        for (String filename:args){
            DigestRunnable dr = new DigestRunnable(filename);
            Thread t = new Thread(dr);
            t.start();
        }
    }
}
