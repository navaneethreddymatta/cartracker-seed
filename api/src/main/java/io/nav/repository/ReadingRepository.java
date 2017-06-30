package io.nav.repository;


import io.nav.entity.Reading;
import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */
public interface ReadingRepository {

    public List<Reading> getReadings();

    public List<Reading> getReadingsByVehicle(String vin);

    public Reading getReading(String id);

    public Reading addReading(Reading reading);
}
