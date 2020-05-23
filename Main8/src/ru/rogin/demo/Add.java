package ru.rogin.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Add extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {
            String url = "jdbc:mysql://database/test?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
            String username = "user";
            String password = "password";

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                out.println("Connection to ProductDB succesfull!");
            }

        } catch (Exception ex) {
            out.println("Connection failed...");
            out.println(ex);
        } finally {
            out.close();
        }

    }
}