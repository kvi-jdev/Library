package by.korotkevich.servlets.read;

import by.korotkevich.service.impl.AuthorServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadAuthorServlet", value = "/ReadAuthorServlet")
public class ReadAuthorServlet extends HttpServlet {

    private final AuthorServiceImpl authorService = new AuthorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        authorService.readAll(writer);

    }
}
