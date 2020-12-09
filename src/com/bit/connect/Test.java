package com.bit.connect;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
       //获取区块的总数
        BTCService service = new BTCService();
        int count = service.getBlockCount();
        System.out.println("比特币节点的区块数量"+count);
        //获取最新区块的hash值
        String hash = service.getBestBlockHash();
        System.out.println("最新区块的hash"+hash);

        float difficulty=service.getDifficulty();
        System.out.println(difficulty);
    }
}
