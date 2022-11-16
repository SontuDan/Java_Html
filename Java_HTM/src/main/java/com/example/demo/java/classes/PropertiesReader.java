package com.example.demo.java.classes;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties properties = loadProperties();
    public static final String CONN_URL = PropertiesReader.getProperty("connURL");
    public static final String CONN_USER = PropertiesReader.getProperty("connUser");
    public static final String CONN_PASS = PropertiesReader.getProperty("connPass");

    private static Properties loadProperties() {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("src/main/resources/application.properties")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }
}