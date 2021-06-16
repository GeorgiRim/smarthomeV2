package com.georgirim.smarthome.services;

import com.georgirim.smarthome.models.Device;
import com.georgirim.smarthome.repositorys.DeviceRepository;
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

    public Device getDeviceById(int id) {
        return deviceRepository.findById(id).get();
    }

    public void saveOrUpdate(Device device) {
        deviceRepository.save(device);
    }

    public void delete(int id) {
        deviceRepository.deleteById(id);
    }

    public long count(){
        return deviceRepository.count();
    }
}
