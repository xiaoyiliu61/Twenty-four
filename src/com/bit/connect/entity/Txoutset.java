package com.bit.connect.entity;

public class Txoutset {
    private long height;
    private String bestblock;
    private long txouts;
    private long bogosize;
    private String hash_serialized;
    private long disk_size;
    private double total_amount;

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getBestblock() {
        return bestblock;
    }

    public void setBestblock(String bestblock) {
        this.bestblock = bestblock;
    }

    public long getTxouts() {
        return txouts;
    }

    public void setTxouts(long txouts) {
        this.txouts = txouts;
    }

    public long getBogosize() {
        return bogosize;
    }

    public void setBogosize(long bogosize) {
        this.bogosize = bogosize;
    }

    public String getHash_serialized() {
        return hash_serialized;
    }

    public void setHash_serialized(String hash_serialized) {
        this.hash_serialized = hash_serialized;
    }

    public long getDisk_size() {
        return disk_size;
    }

    public void setDisk_size(long disk_size) {
        this.disk_size = disk_size;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
