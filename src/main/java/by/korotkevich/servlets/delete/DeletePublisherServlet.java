package by.korotkevich.servlets.delete;

import by.korotkevich.menu.MenuConstant;
import by.korotkevich.util.ConnectionManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "DeletePublisherServlet", value = "/DeletePublisherServlet")
public class DeletePublisherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String publisherName = request.getParameter("publisherName");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM PUBLIC.PUBLISHER " +
                    "WHERE PUBLISHER_NAME=?");
            statement.setString(1, publisherName);
            int i = statement.executeUpdate();
            if (i > 0) {
                writer.println("<font color=green size=16> Publisher deleted <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            } else {
                writer.println("<font color=green size=16> Publisher doesn't exist <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            }
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Publisher not deleted (doesn't exist) <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }
}
