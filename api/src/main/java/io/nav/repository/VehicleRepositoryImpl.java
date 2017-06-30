package io.nav.repository;

import io.nav.entity.Vehicle;
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
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Vehicle> getVehicles() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.getAll",Vehicle.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public Vehicle getVehicleById(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    @Transactional
    public void createVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

}
