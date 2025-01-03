package com.example.onlinebookstore.servlets;

import com.example.onlinebookstore.db.DBConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class BookRegistrationServlet extends HttpServlet {

    private final DBConnectionManager dbConnectionManager;

    @Autowired
    public BookRegistrationServlet(DBConnectionManager dbConnectionManager) {
        this.dbConnectionManager = dbConnectionManager;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        dbConnectionManager.insertBook(title, author, price);

        response.getWriter().write("Book registered successfully!");
    }
}
