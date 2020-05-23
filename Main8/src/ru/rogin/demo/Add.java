package ru.rogin.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class Add extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        try (var db = Db.get()) {
            try (var st = db.createStatement()) {
                st.executeUpdate(
                        "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), password VARCHAR(255))");
            }
        } catch (Exception ex) {
            System.out.println("error");
            System.out.println(ex);
            throw new ServletException("Init failed");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //      request.setAttribute("time", new Date()); // 'time' would be shown on JSP page
   

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/add.jsp");
        view.forward(request, response);
        
        /*
         * try { String url =
         * "jdbc:mysql://database/test?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
         * String username = "user"; String password = "password";
         * 
         * Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().
         * newInstance(); try (Connection conn = DriverManager.getConnection(url,
         * username, password)) {
         * 
         * out.println("Connection to ProductDB succesfull!"); }
         * 
         * } catch (Exception ex) { out.println("Connection failed...");
         * out.println(ex); } finally { out.close(); }
         */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            final var sql = "insert into users (name,password) values (?, ?)";
            try (var db = Db.get().prepareStatement(sql)) {
                db.setString(1, username);
                db.setString(2, password);
                db.executeUpdate();
            }
            response.setStatus(201);
            response.sendRedirect("/list");
        } catch (Exception ex) {
            System.out.println(ex);
            response.setStatus(500);
        }
        
    }
}