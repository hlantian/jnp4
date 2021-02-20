package com.zxiaoyao.jnp4.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 14:51
 */
public class ReverseTest {

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress +"   " + inetAddress.getCanonicalHostName());
            System.out.println();
            inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress +"  " + inetAddress.getHostName());
            System.out.println(inetAddress +"  " + inetAddress.getCanonicalHostName());
            byte[] ips = inetAddress.getAddress();
            String[]ipss = new String[ips.length];
            for(int i = 0;i<ips.length;i++){
                System.out.println(ips[i]);
                ipss[i] = IntByteTools.byte12int(ips[i]) +"";
            }
            System.out.println(inetAddress +"  " + String.join(".",ipss));
            System.out.println(inetAddress +"  " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
