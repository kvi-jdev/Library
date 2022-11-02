package by.korotkevich.servlets.read;

import by.korotkevich.entity.Author;
import by.korotkevich.menu.MenuConstant;
import by.korotkevich.util.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ReadAuthorServlet", value = "/ReadAuthorServlet")
public class ReadAuthorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PUBLIC.AUTHOR " +
                    "ORDER BY ID_AUTHOR");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_AUTHOR");
                String name = resultSet.getString("AUTHOR_NAME");
                Author author = new Author(id, name);
                writer.println("<h2>" + author + "</h2>");

            }
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Error <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }
}
