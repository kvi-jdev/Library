package by.korotkevich.servlets.add;

import by.korotkevich.service.impl.AuthorServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddAuthorServlet", value = "/AddAuthorServlet")
public class AddAuthorServlet extends HttpServlet {
    private final AuthorServiceImpl authorService = new AuthorServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorName = req.getParameter("authorName");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        authorService.add(writer, authorName);

    }
}
