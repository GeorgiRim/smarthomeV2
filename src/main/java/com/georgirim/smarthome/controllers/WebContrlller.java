package com.georgirim.smarthome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Calendar;

@Controller
public class WebContrlller {

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("today",Calendar.getInstance().getTime());
        return "main";
    }

    @GetMapping("/api")
    public String api(@RequestParam(value = "id", defaultValue = "none") String id, @RequestParam(value = "value", defaultValue = "none") String value, Model model) {
        //model.addAttribute("today",Calendar.getInstance().getTime());
        return "ok";
    }
}