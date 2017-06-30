package io.nav.service;

import io.nav.entity.Alert;
import io.nav.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    AlertRepository alertRepository;

    public List<Alert> getAllAlerts() {
        return alertRepository.getAllAlerts();
    }

    public List<Alert> getAlerts(String vin) {
        return alertRepository.getAlerts(vin);
    }

}
