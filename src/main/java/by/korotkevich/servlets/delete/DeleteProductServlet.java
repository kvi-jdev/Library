package by.korotkevich.servlets.delete;

import by.korotkevich.service.impl.ProductServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DeleteProductServlet", value = "/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

    private final ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int productId = Integer.parseInt(product.split(", ")[0].trim());
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println(productId);
        productService.delete(writer,productId);
    }
}
