package com.zxiaoyao.jnp4.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/4 14:22
 */
public class InstanceCallbackDigestUserInterface {

    private String filename;
    private byte[] digest;

    public InstanceCallbackDigestUserInterface(String filename) {
        this.filename = filename;
    }

    public void calculateDigest(){
        InstanceCallbackDigest icb = new InstanceCallbackDigest(filename,this);
        Thread t = new Thread(icb);
        t.start();
    }

    public void receiveDigest(byte[] digest){
        this.digest = digest;
        System.out.println(this);
    }

    public String toString(){
        String result = filename+": ";
        if(digest != null){
            result += DatatypeConverter.printHexBinary(digest);
        }else {
            result += "digest not available";
        }
        return result;
    }

    public static void main(String[] args) {
        for(String filename:args){
            InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
            d.calculateDigest();
        }
    }
}
