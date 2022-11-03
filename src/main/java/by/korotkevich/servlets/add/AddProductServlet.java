package by.korotkevich.servlets.add;


import by.korotkevich.service.impl.ProductServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {

    private final ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        String authorIdString = req.getParameter("authorId");
        String publisherIdString = req.getParameter("publisherId");
        String date = req.getParameter("date");
        int authorId = Integer.parseInt(authorIdString.split(",")[0]);
        int publisherId = Integer.parseInt(publisherIdString.split(",")[0]);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        productService.add(writer, productName, authorId, publisherId, date);


    }


}
