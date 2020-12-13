package com.bit.connect.entity;

public class ChainTipStatus {
    private String invalid;
    private String headers_only;
    private String valid_headers;
    private String valid_fork;
    private String active;

    public String getInvalid() {
        return invalid;
    }

    public void setInvalid(String invalid) {
        this.invalid = invalid;
    }

    public String getHeaders_only() {
        return headers_only;
    }

    public void setHeaders_only(String headers_only) {
        this.headers_only = headers_only;
    }

    public String getValid_headers() {
        return valid_headers;
    }

    public void setValid_headers(String valid_headers) {
        this.valid_headers = valid_headers;
    }

    public String getValid_fork() {
        return valid_fork;
    }

    public void setValid_fork(String valid_fork) {
        this.valid_fork = valid_fork;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
