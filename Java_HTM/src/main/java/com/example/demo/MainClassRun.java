package com.example.demo;
import java.sql.SQLException;

import com.example.demo.java.classes.SQLConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.demo.java.classes.SQLQuery.showDataAutentification;

@SpringBootApplication
public class MainClassRun {
    public static void main(String[] args) throws SQLException {
        showDataAutentification();
        SQLConnection con = new SQLConnection();
        con.connectMyDB();
        SpringApplication.run(MainClassRun.class, args);
    }
}