package by.korotkevich.servlets.delete;

import by.korotkevich.service.impl.AuthorServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "DeleteAuthorServlet", value = "/DeleteAuthorServlet")
public class DeleteAuthorServlet extends HttpServlet {
    private final AuthorServiceImpl authorService = new AuthorServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorName = request.getParameter("authorName");
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        authorService.delete(writer,authorName);
    }
}
