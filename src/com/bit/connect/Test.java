package com.bit.connect;

import com.bit.connect.entity.*;

import java.util.List;

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

        String address = service.getNewAddress("ly", ADDRESS_TYPE.P2SH_SEGWIt);
        System.out.println("得到的地址是:"+address);

        String connectionCount = service.getConnectionCount();
        System.out.println("得到的连接总数："+connectionCount);

        PreBlockData preData= service.preciousBlockByBlockHash("000000000000016f317ae29898169ef9612823883d4dfd472e37de47ed618850");
        System.out.println("最早的区块信息："+preData);

        Nodeinfo nodeinfo = service.getAddedNodeInfo("default");
        System.out.println("得到添加的节点信息"+nodeinfo);

        MemPool memPool = service.getMemPoolInfo();
        System.out.println("内存池信息"+memPool.getSize());

        List<ChainTip> chainTips =service.getChainTips();
        System.out.println("获取链的技巧"+chainTips);

        BlockFilter blockFilter = service.getBlockFilter("00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09",("basic"));
        System.out.println("得到区块过滤"+blockFilter);

        List<ListLock> listLocks =service.listLockUnspent();
        System.out.println("锁住未消耗的列表"+listLocks);

        Txoutset txoutset = service.getTxOutsetInfo();
        System.out.println("通过文本开头信息得到高度:"+txoutset.getHeight());

        WaitBlock waitBlock = service.waitForNewBlock(3);
        System.out.println("根据新区块的推迟时间获取hash"+waitBlock.getHash());
    }
}
