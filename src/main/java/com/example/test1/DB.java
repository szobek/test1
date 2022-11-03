package com.example.test1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DB {


    private static final String DATABASE_URL = "jdbc:mysql://szobekweb.hu:3306/szobekwe_wp1";
    private static final String DATABASE_USERNAME = "szobekwe_java";
    private static final String DATABASE_PASSWORD = "BN^%H7$-(U7T";
    Connection connection;
    private final ObservableList<Cars> data = FXCollections.observableArrayList();
    private final ObservableList<carRoute> routesList = FXCollections.observableArrayList();

    public DB() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertData(Cars car) {
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
                data.add(new Cars(frsz, vin, "", "", "", 1, 1368.0, 1));

            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getData() {

    }

    public ObservableList<Cars> getCars() {
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
            ResultSet rs = st.executeQuery("SELECT * FROM routes WHERE frsz='"+frsz+"'");

            while (rs.next()) {
                String cr = rs.getString("frsz");
                Integer km = rs.getInt("route");
                routesList.add(new carRoute(km, cr));
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}
