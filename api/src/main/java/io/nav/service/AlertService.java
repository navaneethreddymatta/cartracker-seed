package io.nav.service;

import io.nav.entity.Alert;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

public interface AlertService {

    public List<Alert> getAllAlerts();

    public List<Alert> getAlerts(String vin);

}
