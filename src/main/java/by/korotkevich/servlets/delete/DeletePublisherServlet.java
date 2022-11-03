package by.korotkevich.servlets.delete;

import by.korotkevich.service.impl.PublisherServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletePublisherServlet", value = "/DeletePublisherServlet")
public class DeletePublisherServlet extends HttpServlet {

    final PublisherServiceImpl publisherService = new PublisherServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String publisherName = request.getParameter("publisherName");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        publisherService.delete(writer,publisherName);
    }
}
