package com.georgirim.smarthome.controllers;

import com.georgirim.smarthome.services.DeviceService;
import com.georgirim.smarthome.models.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResetController {
    Logger logger = LoggerFactory.getLogger(ResetController.class);
    //private static List deviceList = new ArrayList<Device>();
    @Autowired
    DeviceService deviceService;

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
        deviceService.saveOrUpdate(new Device(type,headers.getHost().getHostName()));
        logger.info("New Device ip=" + headers.getHost().getHostName() + " type=" + type);
        //deviceRepository.save(device);
        //deviceList.add(device);
        return "ok";
    }

    @GetMapping("/api")
    public String api(@RequestParam(value = "id", defaultValue = "none") String id, @RequestParam(value = "value", defaultValue = "none") String value, Model model) {
        //model.addAttribute("today",Calendar.getInstance().getTime());
        return "ok";
    }

}
