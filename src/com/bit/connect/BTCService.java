package com.bit.connect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bit.connect.entity.BlockChainInfo;
import com.bit.connect.entity.BlockData;
import com.bit.connect.entity.Result;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class BTCService {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
    }

    public String getNewAddress(String label,String address_type){
        String json = BcRPCUtils.prepareJSON("getnewaddress",label,address_type);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 根据区块hash值获取指定区块的信息
     * @param hash
     * @return
     */
    public BlockData getBlockByHash(String hash){
        String json = BcRPCUtils.prepareJSON("getblock",hash);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSON.parseObject(result.getData().getResult(), BlockData.class);
        }
        return null;
    }

    /**
     *
     * 根据高度获取指定hash值
     * @param height
     * @return
     */
    public String getBlockHashByHeight(int height){
        String json = BcRPCUtils.prepareJSON("getblockhash",height);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
           return result.getData().getResult();
        }
        return null;
    }

    public BlockChainInfo getBlockChainInfo1(){
        String json = BcRPCUtils.prepareJSON("getblockchaininfo");
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            String  info= result.getData().getResult();
            return JSON.parseObject(info, BlockChainInfo.class);
        }else{
            return null;
        }
    }


    public Object getBlockChainInfo(){
        String json = BcRPCUtils.prepareJSON("getblockchaininfo");
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            String countStr = result.getData().getResult();
            return JSONObject.parseObject(countStr);

        }else{
            return null;
        }
    }

    public double getDifficulty() {
        String json = BcRPCUtils.prepareJSON("getdifficulty");
        Result result = BcRPCUtils.sendPost(map, json);

        assert result != null;
        if (result.getCode() == HttpStatus.SC_OK) {
            String countStr= result.getData().getResult();
            return Double.parseDouble(countStr);

        } else {
            return -1;
        }
    }
    /**
     * 获取最新区块的hash值
     *
     * @return 返回最新区块的hash，查询失败返回 null
     */
    public String getBestBlockHash() {
        String json = BcRPCUtils.prepareJSON("getbestblockhash");
        System.out.println(json);
        Result result = BcRPCUtils.sendPost(map, json);
        assert result != null;
        if (result.getCode() == HttpStatus.SC_OK) {
            return  result.getData().getResult();

        }
        return null;
    }
    public int getBlockCount(){
        //1\json
        //2\post请求
        String json = BcRPCUtils.prepareJSON("getblockcount");
        Result result=BcRPCUtils.sendPost(map,json);
        assert result != null;
        if (result.getCode()== HttpStatus.SC_OK){
           String countStr= result.getData().getResult();
            return  Integer.parseInt(countStr);

        }else {
            return -1;//-1代表查询失败
        }

    }
}
