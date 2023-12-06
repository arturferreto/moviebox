package com.ifrs.moviebox.controllers;

import com.ifrs.moviebox.dao.GenreDAO;
import com.ifrs.moviebox.dao.MovieDAO;
import com.ifrs.moviebox.dao.WatchedDAO;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String params = request.getParameter("params");

        if (params == null || params.equals("buscar-todos")) {
            MovieDAO dao = new MovieDAO();
            List<Movies> movies = dao.getAll();

            request.setAttribute("movies", movies);

            request.getRequestDispatcher("movies/index.jsp").forward(request, response);

            return;
        }

        if (params.equals("criar")) {
            GenreDAO genreDAO = new GenreDAO();
            request.setAttribute("genres", genreDAO.getAll());
            request.setAttribute("movie", new Movies());

            request.getRequestDispatcher("movies/create.jsp").forward(request, response);

            return;
        }

        if (params.equals("inserir")) {
            String name = request.getParameter("name");
            int genreId = Integer.parseInt(request.getParameter("genreId"));
            byte watchlist = (byte) (request.getParameter("watchlist") == null ? 0 : 1);

            Movies movie = new Movies();
            movie.setName(name);
            movie.setGenresByGenreId(new GenreDAO().getById(genreId));
            movie.setWatchlist(watchlist);

            MovieDAO dao = new MovieDAO();
            dao.create(movie);

            response.sendRedirect("filmes");

            return;
        }

        if (params.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            MovieDAO dao = new MovieDAO();
            Movies movie = dao.getById(id);
            request.setAttribute("movie", movie);

            GenreDAO genreDAO = new GenreDAO();
            request.setAttribute("genres", genreDAO.getAll());

            request.getRequestDispatcher("movies/edit.jsp").forward(request, response);

            return;
        }

        if (params.equals("atualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int genreId = Integer.parseInt(request.getParameter("genreId"));
            byte watchlist = (byte) (request.getParameter("watchlist") == null ? 0 : 1);

            MovieDAO dao = new MovieDAO();
            Movies movie = dao.getById(id);
            movie.setName(name);
            movie.setGenresByGenreId(new GenreDAO().getById(genreId));
            movie.setWatchlist(watchlist);

            dao.update(movie);

            response.sendRedirect("filmes");

            return;
        }

        if (params.equals("deletar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            MovieDAO dao = new MovieDAO();
            Movies movie = dao.getById(id);

            WatchedDAO watchedDAO = new WatchedDAO();
            watchedDAO.deleteByMovieId(id);

            dao.delete(movie);

            response.sendRedirect("filmes");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
