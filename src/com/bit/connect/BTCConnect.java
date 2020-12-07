package com.bit.connect;

import com.alibaba.fastjson.JSONObject;

import java.util.Base64;

public class BTCConnect {
    private static final String RPCUSER = "user";
    private static final String RPCPASSWORD = "user";



    //maven :管理和构建项目的依赖和配置
    //依赖的配置：xml文件
    public static void main(String[] args) {
        System.out.println("hello world");

        JSONObject object = new JSONObject();
        object.put("id",System.currentTimeMillis()+"");
        object.put("jsonrpc","2.0");//rpc服务协议版本
        object.put("method","getblockcount");
        //object.put("params","");
        object.put("Authorization","Basic"+ base64Encode(RPCUSER+"："+RPCPASSWORD));
        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);
    }

    private static String base64Encode(String s) {
        return null;
    }


    /**
     * 1.准备json-rpc通信的json数据
     * 2.使用java网络通信进行rpc链接
     * 3.接收java中的http形式的rpc链接响应
     * 4.处理结果
     */


}
