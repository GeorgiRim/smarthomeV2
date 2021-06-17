package com.georgirim.smarthome.controllers;

import com.georgirim.smarthome.services.DeviceService;
//import com.georgirim.smarthome.repositorys.DeviceRepository;
import com.georgirim.smarthome.services.RelayDeviceService;
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

    @Autowired
    RelayDeviceService relayDeviceService;

    @GetMapping("/")
    public String mainController(Model model) {
        List deviceList =  deviceService.getAllDevices();
        model.addAttribute("today",Calendar.getInstance().getTime());
        model.addAttribute("devices", deviceService.getAllDevices());
        model.addAttribute("relayDevices", relayDeviceService.getAllRelayDevice());
        logger.info("Main page response");
        return "main";
    }

}