package com.zxiaoyao.jnp4.thread;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/4 14:13
 */
public class CallbackDigest implements Runnable {

    private String filename;

    public CallbackDigest(String filename) {
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
            CallbackDigestUserInterface.receiveDigest(digest,filename);
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
}
