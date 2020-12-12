package com.bit.connect.entity;

public class CHAINTIPS {
    private long height;
    private String hash;
    private long branchlen;
    private String status;

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getBranchlen() {
        return branchlen;
    }

    public void setBranchlen(long branchlen) {
        this.branchlen = branchlen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
