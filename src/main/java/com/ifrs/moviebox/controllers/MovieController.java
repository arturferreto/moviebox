package com.ifrs.moviebox.controllers;

import com.ifrs.moviebox.dao.GenreDAO;
import com.ifrs.moviebox.dao.MovieDAO;
import com.ifrs.moviebox.models.Movies;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/filmes")
public class MovieController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    MovieDAO dao = new MovieDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String params = request.getParameter("params");

        if (params == null || params.equals("buscar-todos")) {
            List<Movies> movies = dao.getAll();

            request.setAttribute("movies", movies);

            request.getRequestDispatcher("movies/index.jsp").forward(request, response);

            return;
        }

        if (params.equals("criar")) {
            request.getRequestDispatcher("movies/create.jsp").forward(request, response);
        }

        if (params.equals("inserir")) {
            Movies movie = new Movies();
            movie.setName(request.getParameter("name"));
            movie.setGenresByGenreId(new GenreDAO().getById(Integer.parseInt(request.getParameter("genreId"))));
            movie.setWatchlist((byte) Integer.parseInt(request.getParameter("watchlist")));

            dao.create(movie);

            response.sendRedirect("filmes");
        }

        if (params.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Movies movie = dao.getById(id);

            request.setAttribute("movie", movie);

            request.getRequestDispatcher("movies/edit.jsp").forward(request, response);
        }

        if (params.equals("atualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Movies movie = dao.getById(id);
            movie.setName(request.getParameter("name"));
            movie.setGenresByGenreId(new GenreDAO().getById(Integer.parseInt(request.getParameter("genreId"))));
            movie.setWatchlist((byte) Integer.parseInt(request.getParameter("watchlist")));

            dao.update(movie);

            response.sendRedirect("filmes");
        }

        if (params.equals("deletar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Movies movie = dao.getById(id);

            dao.delete(movie);

            response.sendRedirect("filmes");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
