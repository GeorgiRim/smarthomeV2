package com.georgirim.smarthome.controllers;

import com.georgirim.smarthome.mysql.Device;
import com.georgirim.smarthome.mysql.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
public class WebContrlller {
    Logger logger = LoggerFactory.getLogger(WebContrlller.class);

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("today",Calendar.getInstance().getTime());
        return "main";
    }
/*
    @GetMapping("/api")
    public String api(@RequestParam(value = "id", defaultValue = "none") String id, @RequestParam(value = "value", defaultValue = "none") String value, Model model) {
        //model.addAttribute("today",Calendar.getInstance().getTime());
        return "ok";
    }

 */
    @GetMapping("/add")
    public @ResponseBody String addNewDevice (@RequestParam String type, @RequestHeader HttpHeaders headers){
        Device device = new Device();
        device.setType(type);
        device.setIp(headers.getHost().getAddress().toString());
        logger.debug("New Device ip=" + headers.getHost().getAddress().toString() + " type=" + type);
        deviceRepository.save(device);
        return "Saved";
    }
}