package com.zxiaoyao.jnp4.io.in;

import com.zxiaoyao.jnp4.FileConstants;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description
 * @Author hlantian
 * @Date 2021/2/1 10:32
 */
public class IOinTest3 {

    public static void main(String[] args) {
        IOinTest3 test3 = new IOinTest3();
        test3.test();
    }

    public void test() {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            URL url = new URL(
                    "https://pics1.baidu.com/feed/c9fcc3cec3fdfc03b7abcaaa44897c93a5c2260a.jpeg?token=e494fa5216484d3ade1b576009d263b3&s=8A229E0A40BBD98C331899F1030050A2");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            inputStream = conn.getInputStream();
            byte[] data = readInputStream(inputStream);
            File file = new File(FileConstants.FILE_WORK_PATH + File.separator + "a.jpg");
            outputStream = new FileOutputStream(file);
            outputStream.write(data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(outputStream);
            FileConstants.close(inputStream);
        }
    }

    public byte[] readInputStream(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        byte[] result = new byte[0];
        int len = 0;
        try {

            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
                System.out.println("-------------------------------------------");

                System.out.println("buff.length = " +buffer.length + "| len =" + len);
                for(byte b :buffer){
                    System.out.print(b);
                }

            }
            result = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileConstants.close(outputStream);

        }
        return result;
    }
}
