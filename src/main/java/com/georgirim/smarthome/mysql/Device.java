package com.georgirim.smarthome.mysql;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
public class Device {
    //@Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String ico;

    private String ip;

    private Type type;

    public Device(Type type, String ip){

        if(ico == null){
            switch (type){
                case FIRE:ico = "https://e7.pngegg.com/pngimages/874/595/png-clipart-smoke-detector-fire-alarm-control-panel-conflagration-fire-protection-smoke-smoke-smoke-detector-thumbnail.png"; break;
                case CAM:ico = "https://www.pngfind.com/pngs/m/136-1367874_web-camera-png-free-download-webcam-png-transparent.png"; break;
                case SUNSET:ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg"; break;
                case TEPERATURE:ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg"; break;
                default: ico = "https://i.pinimg.com/originals/8d/cd/59/8dcd596c75a0f2629e7493ea575c8b2a.jpg";
            }
            this.type = type;
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

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
