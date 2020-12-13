package com.bit.connect.entity;

public class ChainTip{
    static long height;
    static String hash;
    static long branchlen;
    static ChainTipStatus status;

    public static long getHeight() {
        return height;
    }

    public static void setHeight(long height) {
        ChainTip.height = height;
    }

    public static String getHash() {
        return hash;
    }

    public static void setHash(String hash) {
        ChainTip.hash = hash;
    }

    public static long getBranchlen() {
        return branchlen;
    }

    public static void setBranchlen(long branchlen) {
        ChainTip.branchlen = branchlen;
    }

    public static ChainTipStatus getStatus() {
        return status;
    }

    public static void setStatus(ChainTipStatus status) {
        ChainTip.status = status;
    }
}
