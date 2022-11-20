package com.example.test1;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DB {


    private static final String DATABASE_URL = "jdbc:mysql://szobekweb.hu:3306/szobekwe_wp1";
    private static final String DATABASE_USERNAME = "szobekwe_java";
    private static String DATABASE_PASSWORD = "";
    Connection connection;
    private final ObservableList<Car> data = FXCollections.observableArrayList(cars -> new Observable[]{
        cars.frszProperty()
    });
    private final ObservableList<carRoute> routesList = FXCollections.observableArrayList();

    public String all = "";

    public DB() {
        DATABASE_PASSWORD = new Psw().setPsw();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void insertData(Car car) {
        try {
            String frsz = car.getFrsz();
            String vin = car.getVin();
            String query = " insert into cars (frsz,vin)" + " values (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, frsz);
            preparedStatement.setString(2, vin);


            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getFrsz() {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars");

            while (rs.next()) {
                String frsz = rs.getString("frsz");
                String vin = rs.getString("vin");
                String brand = rs.getString("brand");
                String type = rs.getString("type");
                String operator = rs.getString("operator");
                String owner_id = rs.getString("owner_id");
                String stroke = rs.getString("stroke");
                String performance = rs.getString("performance");
                String fuel = rs.getString("fuel");
                data.add(new Car(frsz, vin, brand, type, operator, Integer.parseInt(owner_id), Integer.parseInt(stroke),fuel, Integer.parseInt(performance)));

            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getData() {

    }

    public ObservableList<Car> getCars() {
        getFrsz();
        return data;
    }

    public ObservableList<carRoute> getRoutes(String frsz) {
        getRoutesByCarFrsz(frsz);
        return routesList;
    }

    public void getRoutesByCarFrsz(String frsz) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM routes WHERE frsz='" + frsz + "'");

            while (rs.next()) {
                String cr = rs.getString("frsz");
                Integer km = rs.getInt("route");
                routesList.add(new carRoute(km, cr));
            }
            getSumRoute(frsz);
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getSumRoute(String frsz) {
        try {
            Statement st = connection.createStatement();
            ResultSet allRoutes = st.executeQuery("SELECT SUM(route) as sumroutes FROM `routes`  WHERE  frsz='" + frsz + "'");
            if (allRoutes.next()) {
                all = allRoutes.getString("sumroutes");
            }
            st.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }


    }

}
