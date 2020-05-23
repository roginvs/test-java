package ru.rogin.demo;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class List extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var users = new ArrayList<String>();

        try {
            final var sql = "select name from users";
            try (var resultSet = Db.get().createStatement().executeQuery(sql)) {

                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    users.add(name);
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);
            response.setStatus(500);
        }

        String[] usersArray = new String[users.size()];
        usersArray = (String[]) users.toArray(usersArray);

        request.setAttribute("users", usersArray);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/list.jsp");

        view.forward(request, response);
    }

}