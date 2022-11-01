package com.example.test1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DB {



    private static final String DATABASE_URL = "jdbc:mysql://szobekweb.hu:3306/szobekwe_wp1";
    private static final String DATABASE_USERNAME = "szobekwe_java";
    private static final String DATABASE_PASSWORD = "BN^%H7$-(U7T";

    private final ObservableList<Cars> data = FXCollections.observableArrayList();
    // private final ObservableList<Person> data = FXCollections.observableArrayList();
    //
    //    @FXML
    public void insertData() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todo  (content, user_id) VALUES ('z',5)");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getData() {

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM todo");

            while (rs.next()) {
                String frsz = rs.getString("frsz");
                String vin = rs.getString("vin");
                data.add(new Cars(frsz,vin,"","","",1,1368.0,1));

            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ObservableList<Cars> fn(){
        getData();

        return data;
    }



}
