package by.korotkevich.service;

import by.korotkevich.entity.Product;

import java.io.PrintWriter;
import java.util.List;

public interface OperationService<T> {
    void add(PrintWriter writer, String name);

    void delete(PrintWriter writer, String name);

    void readAll(PrintWriter writer);

    List<T> readMenu();
}
