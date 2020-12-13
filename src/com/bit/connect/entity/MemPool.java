package com.bit.connect.entity;

public class MemPool {
    private Boolean loaded;
    private long size;
    private long bytes;
    private long usage;
    private long maxmempool;
    private  double mempoolminfee;
    private  double minrelaytefee;

    public Boolean getLoaded() {
        return loaded;
    }

    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getBytes() {
        return bytes;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    public long getUsage() {
        return usage;
    }

    public void setUsage(long usage) {
        this.usage = usage;
    }

    public long getMaxmempool() {
        return maxmempool;
    }

    public void setMaxmempool(long maxmempool) {
        this.maxmempool = maxmempool;
    }

    public double getMempoolminfee() {
        return mempoolminfee;
    }

    public void setMempoolminfee(double mempoolminfee) {
        this.mempoolminfee = mempoolminfee;
    }

    public double getMinrelaytefee() {
        return minrelaytefee;
    }

    public void setMinrelaytefee(double minrelaytefee) {
        this.minrelaytefee = minrelaytefee;
    }
}
