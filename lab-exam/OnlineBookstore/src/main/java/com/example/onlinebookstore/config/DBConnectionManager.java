package com.example.onlinebookstore.config;

import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/BookstoreDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Mingizem@1995";


    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void insertBook(String title, String author, double price) {
        try (Connection conn = openConnection()) {
            String query = "INSERT INTO Books (title, author, price) VALUES (?, ?, ?)";
            try (var stmt = conn.prepareStatement(query)) {
                stmt.setString(1, title);
                stmt.setString(2, author);
                stmt.setDouble(3, price);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

