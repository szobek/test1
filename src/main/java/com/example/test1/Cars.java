package com.example.test1;

import javafx.beans.property.SimpleStringProperty;

public class Cars {

    private SimpleStringProperty frsz;

    private SimpleStringProperty vin;
    String brand;
    String type;
    String operator;
    Integer owner_id;
    Double stroke;
    Integer performance;

    public Cars(
            String frsz,
            String vin,
            String brand,
            String type,
            String operator,
            Integer owner_id,
            Double stroke,
            Integer performance) {
        this.frsz = new SimpleStringProperty(frsz);
        this.vin = new SimpleStringProperty(vin);
        this.brand = brand;
        this.type = type;
        this.operator = operator;
        this.owner_id = owner_id;
        this.stroke = stroke;
        this.performance = performance;
    }
    public String getFrsz() {
        return frsz.get();
    }

    public SimpleStringProperty frszProperty() {
        return frsz;
    }

    public void setFrsz(String frsz) {
        this.frsz.set(frsz);
    }

    public String getVin() {
        return vin.get();
    }

    public SimpleStringProperty vinProperty() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin.set(vin);
    }

}
