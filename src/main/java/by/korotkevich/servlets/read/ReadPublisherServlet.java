package by.korotkevich.servlets.read;

import by.korotkevich.service.impl.PublisherServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadPublisherServlet", value = "/ReadPublisherServlet")
public class ReadPublisherServlet extends HttpServlet {

    final PublisherServiceImpl publisherService = new PublisherServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        publisherService.readAll(writer);
    }
}
