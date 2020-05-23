package ru.rogin.demo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private Db() {
        
    }
    final static Connection get() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException, SQLException {

        String url = "jdbc:mysql://database/test?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
        String username = "user";
        String password = "password";

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        var conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}