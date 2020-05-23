package ru.rogin.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class List extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] users = { "asdasd", "elele" };
        request.setAttribute("users", users);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/list.jsp");

        view.forward(request, response);
    }

}