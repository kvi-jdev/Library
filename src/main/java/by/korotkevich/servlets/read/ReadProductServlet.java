package by.korotkevich.servlets.read;

import by.korotkevich.entity.Product;
import by.korotkevich.menu.MenuConstant;
import by.korotkevich.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ReadProductServlet", value = "/ReadProductServlet")
public class ReadProductServlet extends HttpServlet {

    private final ProductServiceImpl productService = new ProductServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        List<Product> productList = productService.readMenu();
        for (Product prod : productList) {
            writer.println("<h2>" + prod + "</h2>");
        }
        writer.println(MenuConstant.BACK_TO_MAIN_MENU);

    }
}
