package com.example.test1;

public class Cars {
    String frsz;
    String vin;
    String brand;
    String type;
    String operator;
    Integer owner_id;
    Double stroke ;
    Integer performance;

    public Cars(String frsz,
    String vin,
    String brand,
    String type,
    String operator,
    Integer owner_id,
    Double stroke,
    Integer performance){
        this.frsz = frsz;
        this.vin=vin;
        this.brand=brand;
        this.type=type;
        this.operator=operator;
        this.owner_id=owner_id;
        this.stroke =stroke;
        this.performance=performance;
    }
}
