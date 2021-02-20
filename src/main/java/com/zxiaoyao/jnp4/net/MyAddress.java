package com.zxiaoyao.jnp4.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 14:04
 */
public class MyAddress {

    public static void main(String[] args) {
        try {
            InetAddress address =InetAddress.getLocalHost();
            System.out.println(address);
            address = InetAddress.getByName("127.0.0.1");
            System.out.println(address);
            address = InetAddress.getByName("localhost");
            System.out.println(address);
            address = InetAddress.getByName("0.0.0.0");
            System.out.println(address);
            address = InetAddress.getByName("ZXIAOYAO");
            System.out.println(address);
            address = InetAddress.getByName("192.168.100.19");
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
