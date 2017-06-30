package io.nav.entity;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by navanee on 24-06-2017.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.getAll",
                query = "SELECT alert FROM Alert alert"),
        @NamedQuery(name = "Alert.getAlertsByVin",
                query = "SELECT alert FROM Alert alert WHERE vehicle_vin=:paramsVIN")
})
public class Alert {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @OneToOne
    private Reading reading;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private AlertType type;

    public Alert() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public AlertType getType() {
        return type;
    }

    public void setType(AlertType type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", reading=" + reading +
                ", vehicle=" + vehicle +
                ", type=" + type +
                '}';
    }
}
