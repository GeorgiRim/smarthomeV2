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
    public String addNewDevice (@RequestParam String type, @RequestHeader HttpHeaders headers){
        deviceService.saveOrUpdate(new Device(Device.Type.valueOf(type),headers.getHost().getHostName()));
        logger.info("New Device ip=" + headers.getHost().getHostName() + " type=" + type);
        return "ok";
    }

    @GetMapping("/api")
    public String api(@RequestParam(value = "id", defaultValue = "0") int id, @RequestParam(value = "data", defaultValue = "0") int value, Model model) {
        deviceService.getMovieById(id);
        //model.addAttribute("today",Calendar.getInstance().getTime());
        return "ok";
    }

}
