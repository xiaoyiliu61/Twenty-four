package com.bit.connect;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class BTCService {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
    }

    /**
     * 获取最新区块的hash值
     *
     * @return 返回最新区块的hash，查询失败返回 null
     */
    public void getblockchainInfo()

    public float getDifficulty() {
        String json = BcRPCUtils.prepareJSON("getdifficulty");
        Result result = BcRPCUtils.sendPost(map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            String countStr= result.getData().getResult();
            float  count = Float.parseFloat(countStr);
            return count;
        } else {
            return -1;
        }
    }

    public String getBestBlockHash() {
        String json = BcRPCUtils.prepareJSON("getbestblockhash");
        Result result = BcRPCUtils.sendPost(map, json);
        if (result.getCode() == HttpStatus.SC_OK) {
            String countStr = result.getData().getResult();
            return countStr;
        }
        return null;
    }
    public int getBlockCount(){
        //1\json
        //2\post请求
        String json = BcRPCUtils.prepareJSON("getblockcount");
        Result result=BcRPCUtils.sendPost(map,json);
        if (result.getCode()== HttpStatus.SC_OK){
           String countStr= result.getData().getResult();
           int count = Integer.parseInt(countStr);
           return count;
        }else {
            return -1;//-1代表查询失败
        }

    }
}
