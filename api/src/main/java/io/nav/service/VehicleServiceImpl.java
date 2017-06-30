package io.nav.service;

import io.nav.entity.Vehicle;
import io.nav.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    public Vehicle getVehicleById(String vin) {
        Vehicle existing =  vehicleRepository.getVehicleById(vin);
        return existing;
    }

    public void loadVehicles(Vehicle[] vehicles) {
        for(Vehicle vehicle : vehicles) {
            Vehicle vExisting = getVehicleById(vehicle.getVin());
            if(vExisting == null) {
                createVehicle(vehicle);
            } else {
                updateVehicle(vehicle);
            }
        }
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.updateVehicle(vehicle);
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.createVehicle(vehicle);
    }
}
