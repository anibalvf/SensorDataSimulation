package com.example.sensordatasimulation;

import java.io.Serializable;

public class StringInverter implements Serializable {
    public String id;
    private int numPanel;
    private int panelPower;

    public StringInverter(String id, int numPanel, int panelPower) {
        this.id = id;
        this.numPanel = numPanel;
        this.panelPower = panelPower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumPanel() {
        return numPanel;
    }

    public void setNumPanel(int numPanel) {
        this.numPanel = numPanel;
    }

    public int getPanelPower() {
        return panelPower;
    }

    public void setPanelPower(int panelPower) {
        this.panelPower = panelPower;
    }


}
