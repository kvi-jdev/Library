package by.korotkevich.service;

import by.korotkevich.entity.Product;
import java.io.PrintWriter;
import java.util.List;

public interface ProductService {

    void add(PrintWriter writer, String productName, int idAuthor, int idPublisher, String date);

    void delete(PrintWriter writer, int id);

    List<Product> readMenu();
}
