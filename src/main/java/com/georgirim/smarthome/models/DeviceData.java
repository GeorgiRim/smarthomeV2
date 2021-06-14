package com.georgirim.smarthome.models;

import javax.persistence.*;

@Entity
public class DeviceData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private int id;

    private int deviceId;

    private int data;

    public int getDeviceId() {
        return deviceId;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
