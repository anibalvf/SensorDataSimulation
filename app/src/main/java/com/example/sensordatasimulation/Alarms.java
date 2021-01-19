package com.example.sensordatasimulation;

import java.io.Serializable;

public class Alarms implements Serializable {
    private String id;
    private String startDate;
    private String endDate;
    private String type;

    public Alarms(String id, String startDate, String endDate, String type) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public Alarms() {
        this.id = "";
        this.startDate = "";
        this.endDate = "";
        this.type = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
