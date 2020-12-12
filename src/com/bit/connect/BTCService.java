package com.bit.connect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bit.connect.entity.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class BTCService {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
    }

    public CHAINTIPS getChainTips(){
        String json = BcRPCUtils.prepareJSON(Constants.GETCHAINTIPS);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null);{
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSON.parseObject(result.getData().getResult());
        }
        return null;
    }


    public Nodeinfo getAddedNodeInfo(String node){
        String json = BcRPCUtils.prepareJSON(Constants.GETADDEDNODEINFO,node);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSON.parseObject(result.getData().getResult(),Nodeinfo.class);
        }
        return null;
    }

    public String getConnectionCount(){
        String json = BcRPCUtils.prepareJSON(Constants.GETCOUNNECTIONCOUNT);
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
     * 生成比特币的新地址
     * @param label 标签 ，可自定义 legacy，
     * @param address_type  地址类型
     * @return 返回生成的新的比特币地址，如果请求失败，返回null
     */
    public String getNewAddress(String label, ADDRESS_TYPE address_type){
       String type = Constants.getAddressType(address_type);
        String json = BcRPCUtils.prepareJSON(Constants.GETNEWADDRESS,label,type);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCK,hash);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSON.parseObject(result.getData().getResult(), BlockData.class);
        }
        return null;
    }

    public PreBlockData preciousBlockByBlockHash(String blockHash){
        String json = BcRPCUtils.prepareJSON(Constants.PRECIOUSBLOCK,blockHash);
        Result result = BcRPCUtils.sendPost(map,json);
        if (result==null){
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return JSON.parseObject(result.getData().getResult(),PreBlockData.class);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKHASH,height);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCHAININFO);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCHAININFO);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETDIFFICULTY);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETBESTBLOCKHASH);
      //  System.out.println(json);
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
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCOUNT);
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
