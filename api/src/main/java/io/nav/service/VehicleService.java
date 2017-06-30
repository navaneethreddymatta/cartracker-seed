package io.nav.service;

import io.nav.entity.Vehicle;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */
public interface VehicleService {

    public List<Vehicle> getVehicles();

    public Vehicle getVehicleById(String vin);

    public void loadVehicles(Vehicle[] vehicles);

    public Vehicle updateVehicle(Vehicle vehicle);

    public void createVehicle(Vehicle vehicle);
}
