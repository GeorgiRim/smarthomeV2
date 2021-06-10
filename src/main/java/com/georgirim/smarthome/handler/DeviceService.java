package com.georgirim.smarthome.handler;

import com.georgirim.smarthome.mysql.Device;
import com.georgirim.smarthome.mysql.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public List getAllDevices() {
        List devices = new ArrayList();
        deviceRepository.findAll().forEach(movie -> devices.add(movie));
        return devices;
    }

    public Device getMovieById(int id) {
        return deviceRepository.findById(id).get();
    }

    public void saveOrUpdate(Device device) {
        deviceRepository.save(device);
    }

    public void delete(int id) {
        deviceRepository.deleteById(id);
    }
}
