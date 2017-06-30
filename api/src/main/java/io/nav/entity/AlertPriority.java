package io.nav.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by navanee on 24-06-2017.
 */

@Entity
public class AlertPriority {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlertPriority{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
