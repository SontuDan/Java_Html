package com.example.demo.project.classes;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
public class SQLConnection {
    @Getter
    @Setter
    static int idCount = 0;

    public void connectMyDB() {
        HumanDTO var = new HumanDTO();
        try {
            Connection myConn = DriverManager.getConnection(PropertiesReader.CONN_URL,PropertiesReader.CONN_USER,PropertiesReader.CONN_PASS);
            if (myConn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

            Statement myStmt = myConn.createStatement();
            String query = "select count(*) from Information";
            //Executing the query
            ResultSet rs = myStmt.executeQuery(query);
            //Retrieving the result

            rs.next();
            idCount = rs.getInt(1);
            myConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
