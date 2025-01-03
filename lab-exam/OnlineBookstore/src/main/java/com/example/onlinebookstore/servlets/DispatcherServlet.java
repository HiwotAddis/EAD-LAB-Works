package com.example.onlinebookstore.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        RequestDispatcher dispatcher = null;

        if (uri.endsWith("/bookRegistration.html")) {
            dispatcher = request.getRequestDispatcher("/bookRegistration.html");
        } else if (uri.endsWith("/displayBooks.html")) {
            dispatcher = request.getRequestDispatcher("/displayBooks.html");
        } else if (uri.endsWith("/deleteBook.html")) {
            dispatcher = request.getRequestDispatcher("/deleteBook.html");
        } else if (uri.endsWith("/searchBook.html")) {
            dispatcher = request.getRequestDispatcher("/searchBook.html");
        } else if (uri.endsWith("/displayBooks")) {
            dispatcher = request.getRequestDispatcher("/displayBooks");
        } else if (uri.endsWith("/deleteBook")) {
            dispatcher = request.getRequestDispatcher("/deleteBook");
        } else if (uri.endsWith("/searchBooks")) {
            dispatcher = request.getRequestDispatcher("/searchBooks");
        }

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page Not Found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
