package io.nav.repository;

import io.nav.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alert> getAllAlerts() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.getAll",Alert.class);
        return query.getResultList();
    }

    public List<Alert> getAlerts(String vin) {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.getAlertsByVin",Alert.class);
        query.setParameter("paramsVIN", vin);
        return query.getResultList();
    }

}
