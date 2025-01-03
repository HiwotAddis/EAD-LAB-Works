package com.example.onlinebookstore.servlets;

import com.example.onlinebookstore.config.DBConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/searchBooks")
public class SearchBooksServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("title");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (searchQuery == null || searchQuery.isEmpty()) {
            out.println("<h3>Please provide a title to search.</h3>");
            return;
        }
       
        try {
            DBConnectionManager dbManager = new DBConnectionManager();
            Connection connection = dbManager.openConnection();

            String sql = "SELECT * FROM Books WHERE title LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + searchQuery + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            out.println("<h1>Search Results for: " + searchQuery + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");

                out.println("<tr><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + price + "</td></tr>");
            }

            out.println("</table>");
            dbManager.closeConnection();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            out.close();
        }
    }
}
