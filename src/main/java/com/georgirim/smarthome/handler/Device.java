package com.georgirim.smarthome.handler;

public abstract class Device<D> {
    private String ip;
    private String mac;
    private D data;

    public Device(String ip, String mac){
        this.ip = ip;
        this.mac = mac;
    }

    void update(){

    }

    void read(){

    }
}
