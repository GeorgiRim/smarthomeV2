package com.georgirim.smarthome.services;


import com.georgirim.smarthome.models.DeviceData;
import com.georgirim.smarthome.models.RelayDevice;
import com.georgirim.smarthome.repositorys.RelayDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelayDeviceService {

    @Autowired
    RelayDeviceRepository relayDeviceRepository;

    public List getAllRelayDevice() {
        List relayList = new ArrayList();
        relayDeviceRepository.findAll().forEach(data -> relayList.add(data));
        return relayList;
    }

    public RelayDevice getRelayById(int id) {
        return relayDeviceRepository.findById(id).get();
    }

    public void saveOrUpdate(RelayDevice relayDevice) {
        relayDeviceRepository.save(relayDevice);
    }

    public void delete(int id) {
        relayDeviceRepository.deleteById(id);
    }

    public long count(){
        return relayDeviceRepository.count();
    }
}
