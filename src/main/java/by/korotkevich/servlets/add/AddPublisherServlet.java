package by.korotkevich.servlets.add;

import by.korotkevich.service.impl.PublisherServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddPublisherServlet", value = "/AddPublisherServlet")
public class AddPublisherServlet extends HttpServlet {

    final PublisherServiceImpl publisherService = new PublisherServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String publisherName = req.getParameter("publisherName");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        publisherService.add(writer, publisherName);
    }

}
