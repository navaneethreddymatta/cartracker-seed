package io.nav.service;

import io.nav.entity.Alert;
import io.nav.entity.AlertType;
import io.nav.repository.AlertTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by navanee on 28-06-2017.
 */

@Service
public class AlertTypeServiceImpl implements AlertTypeService {

    @Autowired
    AlertTypeRepository alertTypeRepository;

    public AlertType getAlertType(String id) {
        return alertTypeRepository.getAlertType(id);
    }

    public Alert createAlert(Alert alert) {
        return alertTypeRepository.createAlert(alert);
    }
}
