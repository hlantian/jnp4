package com.zxiaoyao.jnp4.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 17:32
 */
public class AddressTest {

    public static void main(String[] args) {
        try {
            System.out.println(getVersion(InetAddress.getByName("localhost")));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static int getVersion(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length;
        return length == 4 ? 4 : length == 6 ? 6 : -1;
    }
}
