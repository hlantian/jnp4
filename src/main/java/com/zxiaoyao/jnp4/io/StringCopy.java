package com.zxiaoyao.jnp4.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/1/29 16:47
 */
public class StringCopy {

    public static void main(String[] args) {

        //BufferedReader 相当于一个大桶，其实就是内存，这里实现了大量大量的读写，而不是读一个字节或
        //字符就直接写入硬盘，加强了对硬盘的保护。
        BufferedReader bfRaeder = null;
        try{
           while (true){ // 循环保证程序不会结束
               //System.in 为标准输入 System.out为标准输出
               //InputStreamReader用于将字节流到字符流的转化，这也就是处理流了
               //在这里相当于2个管道接在System.in于程序之间。
               bfRaeder = new BufferedReader(new InputStreamReader(System.in));
               String line = bfRaeder.readLine();
               System.out.println(line);
               if("SHUTDOWN".equals(line)){
                   System.out.println("结束");
                   break;
               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bfRaeder != null){
                try {
                    bfRaeder.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
