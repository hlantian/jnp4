package com.zxiaoyao.jnp4.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 17:36
 */
public class IPCharacteristics {
    public static void main(String[] args) {
        String ip = "www.baidu.com";
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            System.out.println("inetAddress.isAnyLocalAddress() = " + inetAddress.isAnyLocalAddress());
            System.out.println("inetAddress.isLinkLocalAddress() = " + inetAddress.isLinkLocalAddress());
            System.out.println("inetAddress.isLoopbackAddress() = " + inetAddress.isLoopbackAddress());
            System.out.println("inetAddress.isMCGlobal() = " + inetAddress.isMCGlobal());
            System.out.println("inetAddress.isMCLinkLocal() = " + inetAddress.isMCLinkLocal());
            System.out.println("inetAddress.isMCNodeLocal() = " + inetAddress.isMCNodeLocal());
            System.out.println("inetAddress.isMCOrgLocal() = " + inetAddress.isMCOrgLocal());
            System.out.println("inetAddress.isMCSiteLocal() = " + inetAddress.isMCSiteLocal());
            System.out.println("inetAddress.isMulticastAddress() = " + inetAddress.isMulticastAddress());
            System.out.println("inetAddress.isReachable() = " + inetAddress.isReachable(34));

            NetworkInterface networkInterface = NetworkInterface.getByName("eth11");
            System.out.println(networkInterface.getName());




        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
