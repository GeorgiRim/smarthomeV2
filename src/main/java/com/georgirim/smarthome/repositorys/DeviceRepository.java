package com.georgirim.smarthome.repositorys;

import com.georgirim.smarthome.models.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
}
