package by.korotkevich.service.impl;


import by.korotkevich.entity.Product;
import by.korotkevich.menu.MenuConstant;
import by.korotkevich.service.ProductService;
import by.korotkevich.util.ConnectionManager;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public void add(PrintWriter writer, String productName, int idAuthor, int idPublisher, String date) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO PUBLIC.PRODUCT (PRODUCT_NAME, " +
                    "PRODUCT_DATE, ID_AUTHOR, ID_PUBLISHER) " +
                    "VALUES (?,?,?,?)");
            statement.setString(1, productName);
            statement.setString(2, date);
            statement.setInt(3,idAuthor);
            statement.setInt(4,idPublisher);
            int i = statement.executeUpdate();
            if (i > 0) {
                writer.println("<font color=green size=16> Product added <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            }
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Product not added <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);
        }
    }

    @Override
    public void delete(PrintWriter writer, int id) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM PUBLIC.PRODUCT " +
                    "WHERE ID_RPODUCT=?");
            statement.setInt(1, id);
            int i = statement.executeUpdate();
            if (i > 0) {
                writer.println("<font color=green size=16> Product deleted <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            } else {
                writer.println("<font color=green size=16> Wrong number! Try again! <br>");
                writer.println(MenuConstant.BACK_TO_MAIN_MENU);
            }
        } catch (SQLException e) {
            writer.println("<font color=red size=16> Product not deleted (doesn't exist) <br>");
            writer.println(MenuConstant.BACK_TO_MAIN_MENU);

        }
    }


    @Override
    public List<Product> readMenu() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PUBLIC.PRODUCT " +
                    "LEFT JOIN AUTHOR A on PRODUCT.ID_AUTHOR=A.ID_AUTHOR " +
                    "LEFT JOIN PUBLISHER P on PRODUCT.ID_PUBLISHER=P.ID_PUBLISHER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_PRODUCT");
                String productName = resultSet.getString("PRODUCT_NAME");
                String date = resultSet.getString("PRODUCT_DATE");
                String authorName = resultSet.getString("AUTHOR_NAME");
                String publisherName = resultSet.getString("PUBLISHER_NAME");
                Product product = new Product(id, productName, date, authorName, publisherName);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
