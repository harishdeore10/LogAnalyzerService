package com.credit.suisse.log.analyzer.model;

/*
 * This is an POJO to represent Log structure.
 * Author: Harish Deore
 * */

public class Log {

    private String id;
    private State state;
    private String type;
    private String host;
    private String timestamp;

    //Default Constructor
    public Log() {
    }

    public Log(String id, State state, String timestamp) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
    }

    public Log(String id, State state, String type, String host, String timestamp) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", state=" + state +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
