package com.zxiaoyao.jnp4.thread;

import javax.xml.bind.DatatypeConverter;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/19 17:04
 */
public class JoinDigestUserInterface {

    public static void main(String[] args) {
        ReturnDigest[] digestThreads = new ReturnDigest[args.length];
        for (int i = 0; i < args.length; i++) {
            digestThreads[i] = new ReturnDigest(args[i]);
            digestThreads[i].start();
        }

        for (int i = 0; i < args.length; i++) {
            try {
                digestThreads[i].join();
                StringBuffer result = new StringBuffer(args[i]);
                result.append(": ");
                byte[] digest = digestThreads[i].getDigest();
                result.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
