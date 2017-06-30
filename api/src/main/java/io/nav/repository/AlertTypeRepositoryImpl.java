package io.nav.repository;

import io.nav.entity.Alert;
import io.nav.entity.AlertType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by navanee on 28-06-2017.
 */

@Repository
public class AlertTypeRepositoryImpl implements AlertTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public AlertType getAlertType(String id) {
        return entityManager.find(AlertType.class, id);
    }

    @Transactional
    public Alert createAlert(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

}
