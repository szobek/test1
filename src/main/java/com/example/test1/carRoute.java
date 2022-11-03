package com.example.test1;

import javafx.beans.property.SimpleStringProperty;

public class carRoute {
    public String getRoute() {
        return route.get();
    }

    public SimpleStringProperty routeProperty() {
        return route;
    }

    public void setRoute(String route) {
        this.route.set(route);
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

    SimpleStringProperty route;
    SimpleStringProperty frsz;
    public carRoute(Integer route,String frsz){
this.frsz=new SimpleStringProperty(frsz);
this.route=new SimpleStringProperty(route.toString());
    }

}
