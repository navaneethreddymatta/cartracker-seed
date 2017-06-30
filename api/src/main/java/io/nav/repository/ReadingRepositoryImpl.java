package io.nav.repository;

import io.nav.entity.Reading;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Reading> getReadings() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.getAll",Reading.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Reading> getReadingsByVehicle(String vin) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.getReadingsByVin",Reading.class);
        query.setParameter("paramsVIN", vin);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Reading getReading(String id) {
        return entityManager.find(Reading.class, id);
    }

    @Transactional
    public Reading addReading(Reading reading) {
        // System.out.println(reading.toString());
        entityManager.persist(reading.getTires());
        entityManager.persist(reading);
        return reading;
    }
}
