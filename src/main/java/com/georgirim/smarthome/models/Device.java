package com.georgirim.smarthome.models;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import javax.persistence.*;

import com.georgirim.smarthome.services.DataService;
import com.georgirim.smarthome.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
public class Device {
    //@Autowired
    //DataService dataService;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private int id;

    private String ico;

    private String ip;

    @Enumerated(value = EnumType.STRING)
    private Type type = Type.TEST;

    private int lastdeviceData = 0;

    public Device(){}

    public Device(Type deviceType, String ip){
            switch (deviceType){
                case TEMP:ico = "https://static.tildacdn.com/tild3863-6237-4836-b635-323930613138/noun_1065028.png"; break;
                case HUMI:ico = "https://image.flaticon.com/icons/png/512/219/219816.png"; break;
                case ILLUM:ico = "https://cdn.onlinewebfonts.com/svg/img_144672.png"; break;
                case FIRE:ico = "https://e7.pngegg.com/pngimages/874/595/png-clipart-smoke-detector-fire-alarm-control-panel-conflagration-fire-protection-smoke-smoke-smoke-detector-thumbnail.png"; break;
                case RELAY:ico = "https://www.pngfind.com/pngs/m/136-1367874_web-camera-png-free-download-webcam-png-transparent.png"; break;
                case CAM:ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg"; break;
                default: ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg";
        }
        this.ip = ip;
        this.type = deviceType;
    }

    public enum Type{
        TEMP,
        HUMI,
        ILLUM,
        FIRE,
        RELAY,
        CAM,
        SUNSET,
        TEST
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public Integer getId() {
        return id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getLastdeviceData() {
        return lastdeviceData;
    }

    public void setLastdeviceData(int lastdeviceData) {
        this.lastdeviceData = lastdeviceData;
    }
}
