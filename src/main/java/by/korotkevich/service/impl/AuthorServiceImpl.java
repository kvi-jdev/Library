package by.korotkevich.service.impl;

import by.korotkevich.entity.Author;
import by.korotkevich.menu.MenuConstant;
import by.korotkevich.service.OperationService;
import by.korotkevich.util.ConnectionManager;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements OperationService<Author> {

    @Override
    public void add(PrintWriter writer, String name) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PUBLIC.AUTHOR (AUTHOR_NAME) " +
                    "VALUES (?)");
            statement.setString(1, name);
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

    @Override
    public void delete(PrintWriter writer, String name) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM PUBLIC.AUTHOR " +
                    "WHERE AUTHOR_NAME=?");
            statement.setString(1, name);
            int i = statement.executeUpdate();
            if (i > 0) {
                writer.println("<font color=green size=16> Author deleted <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            } else {
                writer.println("<font color=green size=16> Author doesn't exist <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            }
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Author not deleted (doesn't exist) <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }

    @Override
    public void readAll(PrintWriter writer) {
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

    @Override
    public List<Author> readMenu() {
        List<Author> authorList = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PUBLIC.AUTHOR " +
                    "ORDER BY ID_AUTHOR");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_AUTHOR");
                String name = resultSet.getString("AUTHOR_NAME");
                Author author = new Author(id, name);
                authorList.add(author);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }


}
