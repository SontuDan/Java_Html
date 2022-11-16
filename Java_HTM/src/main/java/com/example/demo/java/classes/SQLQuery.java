package com.example.demo.java.classes;

import io.bretty.console.table.Alignment;
import io.bretty.console.table.ColumnFormatter;
import io.bretty.console.table.Table;


import java.sql.*;

public class SQLQuery {


    static SQLConnection con = new SQLConnection();



    public static void showDataAutentification() throws SQLException {
        String[] headers = {"ID", "name_", "pass","email"};
        int tempid = 0;
        String sql = "";
        try (Connection conn = DriverManager.getConnection(PropertiesReader.CONN_URL, PropertiesReader.CONN_USER, PropertiesReader.CONN_PASS);
             Statement stmt = conn.createStatement();) {

            ResultSet myRs = stmt.executeQuery("select * from Information");
            ColumnFormatter<String> cf1 = ColumnFormatter.text(Alignment.LEFT, 15);
            Table table1 = Table.of(new String[][]{headers}, cf1);
            System.out.println(table1);
            System.out.println("|_______________________________________________|");
            while (myRs.next()) {
                String[][] data = {{myRs.getString("ID"), myRs.getString("name_"), myRs.getString("pass"),myRs.getString("email")}};
                ColumnFormatter<String> cf = ColumnFormatter.text(Alignment.LEFT, 15);
                Table table = Table.of(data, cf);
                System.out.println(table);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void inserDataDB(HumanDTO human) throws SQLException {
        System.out.println("  --------ISNERT CLASS ACCESED-----  ");
        System.out.println(con.getIdCount() );
        System.out.println(human.getUserName() + "  -------------  " + human.getPassWord());
        try (Connection conn = DriverManager.getConnection(PropertiesReader.CONN_URL, PropertiesReader.CONN_USER, PropertiesReader.CONN_PASS); Statement stmt = conn.createStatement();) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Information " + " values (" + (con.getIdCount() + 1) + ",'" + human.userName + "','" + human.passWord +"','" + human.userEmail + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
