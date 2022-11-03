package by.korotkevich.service.impl;

import by.korotkevich.entity.Publisher;
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

public class PublisherServiceImpl implements OperationService<Publisher> {
    @Override
    public void add(PrintWriter writer, String name) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PUBLIC.PUBLISHER (PUBLISHER_NAME) " +
                    "VALUES (?)");
            statement.setString(1, name);
            int i = statement.executeUpdate();
            if (i > 0) {
                writer.println("<font color=green size=16> Publisher added <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            }
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Publisher not added <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }

    @Override
    public void delete(PrintWriter writer, String name) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM PUBLIC.PUBLISHER " +
                    "WHERE PUBLISHER_NAME=?");
            statement.setString(1, name);
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

    @Override
    public void readAll(PrintWriter writer) {
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

    @Override
    public List<Publisher> readMenu() {
        List<Publisher> publisherList = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PUBLIC.PUBLISHER " +
                    "ORDER BY ID_PUBLISHER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_PUBLISHER");
                String name = resultSet.getString("PUBLISHER_NAME");
                Publisher publisher = new Publisher(id, name);
                publisherList.add(publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisherList;
    }
}
