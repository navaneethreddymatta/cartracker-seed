package io.nav.repository;

import io.nav.entity.Alert;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */
public interface AlertRepository {

    public List<Alert> getAllAlerts();

    public List<Alert> getAlerts(String vin);

}
