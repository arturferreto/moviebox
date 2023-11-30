package com.ifrs.moviebox;

import java.io.*;

import com.ifrs.moviebox.dao.GenreDAO;
import com.ifrs.moviebox.models.Genres;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World Artur!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Genres model = new Genres();
        model.setDescription("Action");

        GenreDAO dao = new GenreDAO();
        dao.createGenre(model);


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(dao);
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}