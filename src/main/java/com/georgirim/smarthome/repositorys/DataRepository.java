package com.georgirim.smarthome.repositorys;


import com.georgirim.smarthome.models.DeviceData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DeviceData, Integer> {

}
