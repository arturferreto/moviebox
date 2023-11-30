package com.ifrs.moviebox;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World Artur!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Criar
//        Movies model = new Movies();
//        model.setGenresByGenreId(new GenreDAO().getById(1));
//        model.setName("Hunger Gamer: The Ballad of Songbirds and Snakes");
//        model.setWatchlist((byte) 1);
//
//        MovieDAO dao = new MovieDAO();
//        dao.create(model);

        // Buscar um pelo ID
//        MovieDAO dao = new MovieDAO();
//        Movies model = dao.getById(1);
//
//        // Imprimir o filme
//        PrintWriter out = response.getWriter();
//        out.println("<h1>" + model.getName() + "</h1>");
//        out.println("<h1>" + model.getGenresByGenreId().getDescription() + "</h1>");
//        out.println("<h1>" + model.getWatchlist() + "</h1>");


//         Buscar todos os gêneros
//        MovieDAO dao = new MovieDAO();
//        List<Movies> movies = dao.getAll();
//
//        // Imprimir todos os gêneros
//        PrintWriter out = response.getWriter();
//        for (Movies movie : movies) {
//            out.println("<h1>" + movie.getName() + "</h1>");
//            out.println("<h1>" + movie.getGenresByGenreId().getDescription() + "</h1>");
//            out.println("<h1>" + movie.getWatchlist() + "</h1>");
//        }

        // Atualiizar um gênero
//        Movies model = new Movies();
//        model.setId(1);
//
//        MovieDAO dao = new MovieDAO();
//        model = dao.getById(model.getId());
//
//        model.setName("Hunger Gamer: The Ballad of Songbirds and Snakes");
//        dao.update(model);

        // Deletar um gênero
//        model = new Movies();
//        model.setId(2);
//
//        dao = new MovieDAO();
//        model = dao.getById(model.getId());
//
//        dao.delete(model);
    }

    public void destroy() {
    }
}