package com.georgirim.smarthome.services;


import com.georgirim.smarthome.models.DeviceData;
import com.georgirim.smarthome.repositorys.DataRepository;
import com.georgirim.smarthome.repositorys.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;

    public List getAllData() {
        List dataList = new ArrayList();
        dataRepository.findAll().forEach(data -> dataList.add(data));
        return dataList;
    }

    public DeviceData getDataById(int id) {
        return dataRepository.findById(id).get();
    }

    public void saveOrUpdate(DeviceData device) {
        dataRepository.save(device);
    }

    public void delete(int id) {
        dataRepository.deleteById(id);
    }
}
