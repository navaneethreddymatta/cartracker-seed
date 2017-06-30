package io.nav.controller;

import io.nav.entity.Alert;
import io.nav.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by navanee on 24-06-2017.
 */

@RestController
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService alertService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Alert> getAlerts(@PathVariable("vin") String vin) {
        return alertService.getAlerts(vin);
    }

}
