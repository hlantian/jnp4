package com.zxiaoyao.jnp4.net;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/20 16:13
 */
public class IntByteTools {

    public static byte[] int2byte(int i) {
        byte[] results = new byte[4];
        results[0] = (byte) ((i >> 24) & 0xFF);
        results[1] = (byte) ((i >> 16) & 0xFF);
        results[2] = (byte) ((i >> 8) & 0xFF);
        results[3] = (byte) (i & 0xFF);
        return results;
    }

    public static byte int2byte1(int i){
        return (byte)(i & 0xFF);
    }

    public static int byte2int(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < bytes.length; i++) {
            int shift = (3 - i) * 8;
            value += (bytes[i] & 0xFF) << shift;
        }
        return value;
    }

    public static int byte12int(byte b){
        return b & 0xFF;
    }

    public static void main(String[] args) {
        byte[] bytes = IntByteTools.int2byte(215);
        System.out.println(toString(bytes));
        bytes = new byte[]{0,0,0,-41};
        System.out.println(IntByteTools.byte2int(bytes));

        System.out.println((byte)325);
        System.out.println(IntByteTools.int2byte1(325));
        System.out.println(toString(int2byte(325)));

        bytes = new byte[]{0,0,1,69};
        System.out.println(byte2int(bytes));
    }

    public static String toString(byte[] bytes){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<bytes.length;i++){
            result.append(bytes[i]).append(" ");
        }
        return result.toString();
    }




}
