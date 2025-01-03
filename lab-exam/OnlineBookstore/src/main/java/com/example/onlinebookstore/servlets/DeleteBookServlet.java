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

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("id");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (bookId == null || bookId.isEmpty()) {
            out.println("<h3>No book ID provided.</h3>");
            return;
        }

        try {
            DBConnectionManager dbManager = new DBConnectionManager();
            Connection connection = dbManager.openConnection();

            String sql = "DELETE FROM Books WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(bookId));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h3>Book deleted successfully!</h3>");
            } else {
                out.println("<h3>Failed to delete the book. No book found with the provided ID.</h3>");
            }

            dbManager.closeConnection();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            out.close();
        }
    }
}
