package com.credit.suisse.log.analyzer.model;

import javax.persistence.*;
import java.io.Serializable;


/*
* This is an entity class represent database table structure.
* Author: Harish Deore
* */

@Entity
@Table(name = "EVENT", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Event implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DURATION")
    private Long duration;
    @Column(name = "HOST")
    private String host;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "ALERT")
    private Boolean alert;

    //Default constructor
    public Event() {
    }

    public Event(String id, Long duration, Boolean alert) {
        this.id = id;
        this.duration = duration;
        this.alert = alert;
    }

    public Event(String id, Long duration, String host, String type, Boolean alert) {
        this.id = id;
        this.duration = duration;
        this.host = host;
        this.type = type;
        this.alert = alert;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", duration=" + duration +
                ", host='" + host + '\'' +
                ", type='" + type + '\'' +
                ", alert=" + alert +
                '}';
    }
}
