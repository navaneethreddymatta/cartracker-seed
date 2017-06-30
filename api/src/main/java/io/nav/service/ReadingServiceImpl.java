package io.nav.service;

import io.nav.entity.*;
import io.nav.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    AlertTypeService alertTypeService;

    public List<Reading> getReadings() {
        return readingRepository.getReadings();
    }

    public List<Reading> getReadingsByVehicle(String vin) {
        return readingRepository.getReadingsByVehicle(vin);
    }

    public Reading getReading(String id) {
        return readingRepository.getReading(id);
    }

    public Reading addReading(Reading reading) {
        Reading rd = readingRepository.addReading(reading);
        Vehicle vehicle =  vehicleService.getVehicleById(reading.getVin());
        if(vehicle != null) {
            if (reading.getEngineRpm() > vehicle.getRedLineRpm()) {
                createAlert("at-01", reading, vehicle);
            }
            if (reading.getFuelVolume() < (0.1 * vehicle.getMaxFuelVolume())) {
                createAlert("at-02", reading, vehicle);
            }
            if (getLeastTirePressure(reading.getTires()) < 32 || getMaxTirePressure(reading.getTires()) > 36) {
                createAlert("at-03", reading, vehicle);
            }
            if (reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()) {
                createAlert("at-04", reading, vehicle);
            }
        }
        return reading;
    }

    public int getLeastTirePressure(Tire tireSet) {
        int leastValue = Integer.MAX_VALUE;
        if(tireSet.getFrontLeft() < leastValue)
            leastValue = tireSet.getFrontLeft();
        if(tireSet.getFrontRight() < leastValue)
            leastValue = tireSet.getFrontRight();
        if(tireSet.getRearLeft() < leastValue)
            leastValue = tireSet.getRearLeft();
        if(tireSet.getRearRight() < leastValue)
            leastValue = tireSet.getRearRight();
        return leastValue;
    }

    public int getMaxTirePressure(Tire tireSet) {
        int maxValue = Integer.MIN_VALUE;
        if(tireSet.getFrontLeft() > maxValue)
            maxValue = tireSet.getFrontLeft();
        if(tireSet.getFrontRight() > maxValue)
            maxValue = tireSet.getFrontRight();
        if(tireSet.getRearLeft() > maxValue)
            maxValue = tireSet.getRearLeft();
        if(tireSet.getRearRight() > maxValue)
            maxValue = tireSet.getRearRight();
        return maxValue;
    }

    public void createAlert(String alertTypeId, Reading reading, Vehicle vehicle) {
        Alert alert = new Alert();
        alert.setReading(reading);
        alert.setVehicle(vehicle);
        AlertType alertType = (alertTypeService.getAlertType(alertTypeId));
        alert.setType(alertType);
        alertTypeService.createAlert(alert);
    }

}
