package com.georgirim.smarthome.mysql;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import javax.persistence.*;

import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private int id;

    private String ico;

    private String ip;

    private int type;

    public Device(){}

    public Device(int type, String ip){

        if(ico == null){
            switch (type){
                case 1:ico = "https://e7.pngegg.com/pngimages/874/595/png-clipart-smoke-detector-fire-alarm-control-panel-conflagration-fire-protection-smoke-smoke-smoke-detector-thumbnail.png"; break;
                case 2:ico = "https://www.pngfind.com/pngs/m/136-1367874_web-camera-png-free-download-webcam-png-transparent.png"; break;
                case 3:ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg"; break;
                case 4:ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg"; break;
                default: ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg";
            }
            //this.type = type;
            this.ip = ip;
        }
    }

    public enum Type{
        FIRE,
        TEPERATURE,
        CAM,
        SUNSET
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

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
