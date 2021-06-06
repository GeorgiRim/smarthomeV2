package com.georgirim.smarthome.controllers;

import com.georgirim.smarthome.mysql.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResetController {
    Logger logger = LoggerFactory.getLogger(ResetController.class);
    private static List deviceList = new ArrayList<Device>();

    @GetMapping("/add")
    public String addNewDevice (@RequestParam int type, @RequestHeader HttpHeaders headers){
        Device.Type type1 = null;
        switch (type){
            case 1:type1=Device.Type.FIRE; break;
            case 2:type1=Device.Type.CAM; break;
            case 3:type1=Device.Type.SUNSET; break;
            case 4:type1=Device.Type.TEPERATURE; break;
            default:type1=Device.Type.TEPERATURE; break;
        }
        //device.setType(type);
        //device.setIp(headers.getHost().getHostName());
        Device device = new Device(type1,headers.getHost().getHostName());
        logger.info("New Device ip=" + headers.getHost().getHostName() + " type=" + type);
        //deviceRepository.save(device);
        deviceList.add(device);
        return "ok";
    }

    public static List getDeviceList() {
        return deviceList;
    }
}
