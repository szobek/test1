package com.example.test1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;
import java.util.ArrayList;

public class DB {



    private static final String DATABASE_URL = "jdbc:mysql://szobekweb.hu:3306/szobekwe_wp1";
    private static final String DATABASE_USERNAME = "szobekwe_java";
    private static final String DATABASE_PASSWORD = "BN^%H7$-(U7T";

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
                ArrayList<Cars> t= new ArrayList<Cars>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String frsz = rs.getString("frsz");
                String vin = rs.getString("vin");
                t.add(new Cars(frsz,vin,"","","",1,1368.0,1));
//                Cars newcar = new Cars("","","","","",1,1368.0,1);
                // print the results
                //System.out.format("%s, %s, %s\n", id, frsz, vin);

            }
            st.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }



}
