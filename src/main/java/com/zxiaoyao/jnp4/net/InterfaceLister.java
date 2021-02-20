package com.zxiaoyao.jnp4.net;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 18:10
 */
public class InterfaceLister {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()){
                NetworkInterface ni = interfaces.nextElement();
                System.out.println(ni);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


}
