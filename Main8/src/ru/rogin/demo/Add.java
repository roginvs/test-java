package ru.rogin.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Add extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "lol kek" + "</h1>");
    }
}