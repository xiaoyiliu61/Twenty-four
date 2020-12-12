package com.bit.connect.entity;

public class Nodeinfo {
    private String addednode;
    private Boolean connected;
    private Nodeaddresses addresses;

    public String getAddednode() {
        return addednode;
    }

    public void setAddednode(String addednode) {
        this.addednode = addednode;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Nodeaddresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Nodeaddresses addresses) {
        this.addresses = addresses;
    }
}
