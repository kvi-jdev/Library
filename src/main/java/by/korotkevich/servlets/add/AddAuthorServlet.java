package by.korotkevich.servlets.add;

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


@WebServlet(name = "AddAuthorServlet", value = "/AddAuthorServlet")
public class AddAuthorServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorName = req.getParameter("authorName");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        try (Connection connection = ConnectionManager.open()) {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO PUBLIC.AUTHOR (AUTHOR_NAME) " +
                    "VALUES (?)");
            statement.setString(1, authorName);
            int i = statement.executeUpdate();
            if (i > 0) {
                writer.println("<font color=green size=16> Author added <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            }
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Author not added <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }
}
