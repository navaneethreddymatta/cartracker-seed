package io.nav.service;

import io.nav.entity.Alert;
import io.nav.entity.AlertType;

/**
 * Created by navanee on 28-06-2017.
 */

public interface AlertTypeService {

    public AlertType getAlertType(String id);

    public Alert createAlert(Alert alert);

}
