package com.zxiaoyao.jnp4.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 13:57
 */
public class OReillyByName {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            System.out.println(address);
            System.out.println();
            address = InetAddress.getByName("104.108.63.6");
            System.out.println(address);
            System.out.println();

            address = InetAddress.getByName("www.163.com");
            System.out.println(address);
            System.out.println();

            address = InetAddress.getByName("219.145.180.41");
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
