package com.ifrs.moviebox.controllers;

import com.ifrs.moviebox.dao.MovieDAO;
import com.ifrs.moviebox.models.Movies;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "movieController", value = "/filmes")
public class MovieController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    MovieDAO dao = new MovieDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        List<Movies> movies = dao.getAll();

        request.setAttribute("movies", movies);

        request.getRequestDispatcher("movies/index.jsp").forward(request, response);
    }
}
