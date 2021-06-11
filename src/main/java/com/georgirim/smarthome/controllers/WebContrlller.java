package com.georgirim.smarthome.controllers;

import com.georgirim.smarthome.services.DeviceService;
//import com.georgirim.smarthome.repositorys.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
public class WebContrlller {
    Logger logger = LoggerFactory.getLogger(WebContrlller.class);

    @Autowired
    DeviceService deviceService;

    @GetMapping("/")
    public String mainController(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        List deviceList =  deviceService.getAllDevices();
        model.addAttribute("today",Calendar.getInstance().getTime());
        model.addAttribute("devices", deviceService.getAllDevices());
        return "main";
    }

}