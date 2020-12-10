package com.bit.connect;

import com.bit.connect.entity.Bip;
import com.bit.connect.entity.BlockChainInfo;
import com.bit.connect.entity.BlockData;
import com.bit.connect.entity.bip1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
       //获取区块的总数
        BTCService service = new BTCService();
        int count = service.getBlockCount();
        System.out.println("比特币节点的区块数量:"+count);
        //获取最新区块的hash值
        String hash = service.getBestBlockHash();
        System.out.println("最新区块的hash:"+hash);

        double difficulty=service.getDifficulty();
        System.out.println("获取区块的难度:"+difficulty);

        Object blockchain = service.getBlockChainInfo();
        System.out.println("获取区块的信息:"+blockchain);

        BlockChainInfo chainInfo=service.getBlockChainInfo1();
        if (chainInfo!=null){
           String chain= chainInfo.getChain();
            System.out.println(chain);
            System.out.println(chainInfo.getDifficulty());

            List<bip1>bipList=chainInfo.getSoftforks();
            for (bip1 bip:bipList){
                System.out.println(bip.getBip65().getHeight());
            }
        }

        String height = service.getBlockHashByHeight(3);
        System.out.println("特定高度的hash值:"+height);


        BlockData data = service.getBlockByHash("0000000082b5015589a3fdf2d4baff403e6f0be035a5d9742c1cae6295464449");
        System.out.println("根据hash值获取指定的区块信息:"+data.getHash());

        String address = service.getNewAddress("ly","legacy");
        System.out.println("得到的地址是:"+address);
    }
}
