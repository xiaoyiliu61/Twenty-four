package com.bit.connect;

import com.bit.connect.entity.ADDRESS_TYPE;

//constans 常量
public class Constants {
    //rpc服务协议
    public static final String RPCUSER = "user";
    public static final String RPCPASSWORD  = "pwd";
    public static final String RPCURL  = "http://127.0.0.1:8332";//rpc的链接
    //地址类型
     public static final String ADDRESS_LEGACY="legacy";
     public static final String ADDRESS_P2SH_SEGWIT="p2sh-segwit";
     public static final String ADDRESS_BECH32="bech32";

     //rpc服务命令
    public static final String GETBLOCKCOUNT="getblockcount";
    public static final String GETBESTBLOCKHASH="getbestblockhash";
    public static final String GETDIFFICULTY="getdifficulty";
    public static final String GETBLOCKCHAININFO="getblockchaininfo";
    public static final String GETBLOCKHASH="getblockhash";
    public static final String PRECIOUSBLOCK="preciousblock";
    //获取指定区块的信息
    public static final String GETBLOCK="getblock";
    //生成一个新的比特币地址
    public static final String GETNEWADDRESS="getnewaddress";
    public static final String GETCOUNNECTIONCOUNT="getconnectioncount";
    public static final String GETADDEDNODEINFO="getaddednodeinfo";
    public static final String GETCHAINTIPS="getchaintips";
    /**
     * 该方法用于根据枚举类型返回对应的比特币地址的类型对应的字符串
     * @param type 枚举
     * @return 比特币地址类型字符串形式
     */
     public static String getAddressType(ADDRESS_TYPE type){
         switch (type){
             case LEGACY:
                return ADDRESS_LEGACY;
            case P2SH_SEGWIt:
                return ADDRESS_P2SH_SEGWIT;
             case BECH32:
              return ADDRESS_BECH32;
             default:
                 return null;
         }
     }
}
