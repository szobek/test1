package com.example.test1;

import java.sql.*;

public class DB {
    private static final String DATABASE_URL = "jdbc:mysql://szobekweb.hu:3306/szobekwe_wp1";
    private static final String DATABASE_USERNAME = "szobekwe_java";
    private static final String DATABASE_PASSWORD = "BN^%H7$-(U7T";

    public static void insertData() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO todo  (content, user_id) VALUES ('z',5)");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void getData() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM todo");
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("content");
                String lastName = rs.getString("user_id");

                // print the results
                System.out.format("%s, %s, %s\n", id, firstName, lastName);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



}
