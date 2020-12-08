package com.bit.connect;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.bit.connect.BcRPCUtils.base64Encode;

public class BTCConnect {
    //RPC服务的用户名，应该与比特币客户端节点的配置文件bitcoin.conf中配置的一样
    private static final String RPCUSER = "user";
    //RPC服务的用户密码，应该与比特币客户端节点的配置文件bitcoin.conf中配置一样
    private static final String RPCPASSWORD = "pwd";

    private static final String RPCURL = "http://127.0.0.1:8332";

    //maven :管理和构建项目的依赖和配置

    //依赖的配置：xml文件
    //例如：配置mysql数据库
    public static void main(String[] args) {
        System.out.println("hello world");

        /**
         * 1.准备json-rpc通信的json数据
         * fastjson.jar
         * 2.使用java网络通信进行rpc链接
         * httpclient、httpcore
         * 请求类型：GET、POST
         * 3.接收java中的http形式的rpc链接响应
         * 4.处理结果
         */

        JSONObject object = new JSONObject();
        object.put("id",System.currentTimeMillis()+"");
        object.put("jsonrpc","2.0");//rpc服务协议版本
        object.put("method","getdifficulty");
        //object.put("params","1");//调用命令时的传参
        //object.put("Authorization","Basic"+ base64Encode(RPCUSER+"："+RPCPASSWORD));
        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

       
        //2.发起一个post类型的网络请求，将第一步准备好json格式数据发送给rpc服务器
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post =new HttpPost(RPCURL);
        //client执行一个post请求
        try {
            //设置请求头
            post.addHeader("Encoding","UTF-8");
            post.addHeader("Content-Type","application/json");
            post.addHeader("Authorization","Basic "+base64Encode(RPCUSER+":"+RPCPASSWORD));
            //entity:实体,
            StringEntity entity = new StringEntity(jsonRpcStr);
            post.setEntity(entity);//设置请求的数据
            HttpResponse response=client.execute(post);//执行网络，阻塞在当前行
            int code = response.getStatusLine().getStatusCode();
            //请求状态码 200 是OK
            System.out.println("rpc请求连接状态码是："+code);
            if (code == 200) {
                System.out.println("rpc请求连接成功");
                String result=EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }else{
               // HttpStatus.SC_ACCEPTED
                //unauthorized
                System.out.println("rpc请求连接失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
