package by.korotkevich.servlets.read;

import by.korotkevich.entity.Author;
import by.korotkevich.entity.Publisher;
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

@WebServlet(name = "ReadPublisherServlet", value = "/ReadPublisherServlet")
public class ReadPublisherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PUBLIC.PUBLISHER " +
                    "ORDER BY ID_PUBLISHER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_PUBLISHER");
                String name = resultSet.getString("PUBLISHER_NAME");
                Publisher publisher = new Publisher(id, name);
                writer.println("<h2>" + publisher + "</h2>");
            }
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Error <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }
}
