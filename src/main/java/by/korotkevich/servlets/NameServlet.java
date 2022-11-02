package by.korotkevich.servlets;

import by.korotkevich.util.DatabaseTables;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NameServlet", value = "/NameServlet")
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/templates/name.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseTables databaseTables = new DatabaseTables();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/templates/name.jsp");
        requestDispatcher.forward(request, response);

    }
}
