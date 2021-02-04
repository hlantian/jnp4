package com.zxiaoyao.jnp4.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/4 14:13
 */
public class CallbackDigestUserInterface {

    public static void main(String[] args) {
        for(String filename: args){
            CallbackDigest cd = new CallbackDigest(filename);
            Thread t = new Thread(cd);
            t.start();
        }
    }

    public static void receiveDigest(byte[] digest, String name){
        StringBuilder result = new StringBuilder(name);
        result.append(": ");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }

}
