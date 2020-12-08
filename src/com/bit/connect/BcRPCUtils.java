package com.bit.connect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Set;

public  class BcRPCUtils {
    private  static  final  String RPCURL="http://127.0.0.1:8332";
    /**
     * 1、准备一个json数据
     * 2、发送一个post请求
     *
     */
     public static String prepareJSON(String method,Object... params){
         JSONObject object = new JSONObject();
         object.put("id",System.currentTimeMillis());
         object.put("jsonrpc","2.0");
         object.put("method",method);
         //几个参数，数据类型
         //可变参数，Object
         if (params!=null){
             object.put("params",params);
         }
         return object.toJSONString();
     }

    /**
     * 发送一个post请求
     * @param headers 请求头设置
     * @param jsonStr 请求体数据
     * @return
     */
     public static Result sendPost(Map<String,String>headers,String jsonStr){
         DefaultHttpClient client = new DefaultHttpClient();
         HttpPost post = new HttpPost(RPCURL);
         post.addHeader("Encoding","UTF-8");
         post.addHeader("Content-Type","application/json");

        if (headers!=null){
            Set<String> keys=headers.keySet();
            for (String key:keys){
                String value = headers.get(key);
                post.addHeader(key,value);
            }
        }

         try {
             StringEntity entity = new StringEntity(jsonStr);
             post.setEntity(entity);
             HttpResponse response = client.execute(post);
             int code = response.getStatusLine().getStatusCode();
             Result result =new Result();
             if (code == HttpStatus.SC_OK){
                 String resEntity = EntityUtils.toString(response.getEntity());
                 result.setCode(code);
                 result.setMsg("请求成功");
                 //反序列化
                 RpcResult rpcResult = JSON.parseObject(resEntity,RpcResult.class);
                 result.setData(rpcResult);
             }else {
                 result.setCode(code);
                 result.setMsg("请求失败");
                 result.setData(null);
             }
             return result;
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         } catch (ClientProtocolException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
        return null;
     }

    public static String base64Encode(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes(StandardCharsets.UTF_8));
    }

}
