package com.example.sensordatasimulation;

import java.io.Serializable;

public class Inverter implements Serializable {
    public String id;
    private String name;
    private String hostName;
    private int port;
    private int maxOutput;

    public Inverter(String id, String name, String hostName, int port, int maxOutput) {
        this.id = id;
        this.name = name;
        this.hostName = hostName;
        this.port = port;
        this.maxOutput = maxOutput;
    }
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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getMaxOutput() {
        return maxOutput;
    }

    public void setMaxOutput(int maxOutput) {
        this.maxOutput = maxOutput;
    }
}
