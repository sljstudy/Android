package net.itjh.testhttp;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jay on 2015/9/7 0007.
 */
public class GetData {


    // 获取网页的html源代码
    public static String getHtml(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setDoOutput(false);

        conn.setRequestProperty("Accept", "*/*");

//        conn.setDoInput(true);

//        conn.connect();
//        URLEncoder.encode(name, "UTF-8");

        conn.getResponseMessage();

        Log.d("conn.getResponseCode()", conn.getResponseCode() + "");

        if (conn.getResponseCode() == 200) {

            InputStream inputStream = conn.getInputStream();
            // 创建字节输出流对象
            ByteArrayOutputStream message = new ByteArrayOutputStream();
            // 定义读取的长度
            int len = 0;
            // 定义缓冲区
            byte buffer[] = new byte[1024];
            // 按照缓冲区的大小，循环读取
            while ((len = inputStream.read(buffer)) != -1) {
                // 根据读取的长度写入到os对象中
                message.write(buffer, 0, len);
            }
            // 释放资源
            inputStream.close();
            message.close();
            // 返回字符串
            String msg = new String(message.toByteArray());

            Log.d("msg -> ", msg);

//            InputStream in = conn.getInputStream();
//            byte[] data = StreamTool.read(in);
//            String html = new String(data, "UTF-8");
//            return html;
        } else {
            Log.d("http code 401", "验证码错误");

            InputStream in = conn.getErrorStream();
            byte[] data = StreamTool.read(in);
            String html = new String(data, "UTF-8");
            return html;


//            // 创建字节输出流对象
//            ByteArrayOutputStream message = new ByteArrayOutputStream();
//            // 定义读取的长度
//            int len = 0;
//            // 定义缓冲区
//            byte buffer[] = new byte[1024];
//            // 按照缓冲区的大小，循环读取
//            while ((len = inputStream.read(buffer)) != -1) {
//                // 根据读取的长度写入到os对象中
//                message.write(buffer, 0, len);
//            }
//            // 释放资源
//            inputStream.close();
//            message.close();
//            // 返回字符串
//            String msg = new String(message.toByteArray());
//
//            Log.d("msg -> ", msg);

        }
        return null;
    }
}