package com.ifrs.moviebox.controllers;

import com.ifrs.moviebox.dao.GenreDAO;
import com.ifrs.moviebox.dao.MovieDAO;
import com.ifrs.moviebox.dao.WatchedDAO;
import com.ifrs.moviebox.models.Watched;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/assistidos")
public class WatchedController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String params = request.getParameter("params");

        if (params == null || params.equals("buscar-todos")) {
            WatchedDAO dao = new WatchedDAO();
            List<Watched> watchedes = dao.getAll();

            request.setAttribute("watchedes", watchedes);

            request.getRequestDispatcher("watchedes/index.jsp").forward(request, response);

            return;
        }

        if (params.equals("criar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            MovieDAO movieDAO = new MovieDAO();
            request.setAttribute("movie", movieDAO.getById(id));

            if (movieDAO.watchedExists(id)) {
                response.sendRedirect("assistidos?params=editar&id=" + movieDAO.getWatchedByMovieId(id).getId());

                return;
            }

            request.getRequestDispatcher("watchedes/create.jsp").forward(request, response);

            return;
        }

        if (params.equals("inserir")) {
            int movieId = Integer.parseInt(request.getParameter("id"));
            short rating = Short.parseShort(request.getParameter("rating"));
            String remark = request.getParameter("remark");
            byte favorite = (byte) (request.getParameter("favorite") == null ? 0 : 1);

            Watched watched = new Watched();
            watched.setMoviesByMovieId(new MovieDAO().getById(movieId));
            watched.setRating(rating);
            watched.setRemark(remark);
            watched.setFavorite(favorite);

            WatchedDAO dao = new WatchedDAO();
            dao.create(watched);

            response.sendRedirect("assistidos");

            return;
        }

        if (params.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            WatchedDAO dao = new WatchedDAO();
            Watched watched = dao.getById(id);
            request.setAttribute("watched", watched);

            request.getRequestDispatcher("watchedes/edit.jsp").forward(request, response);

            return;
        }

        if (params.equals("atualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            short rating = Short.parseShort(request.getParameter("rating"));
            String remark = request.getParameter("remark");
            byte favorite = (byte) (request.getParameter("favorite") == null ? 0 : 1);

            WatchedDAO dao = new WatchedDAO();
            Watched watched = dao.getById(id);
            watched.setMoviesByMovieId(new MovieDAO().getById(movieId));
            watched.setRating(rating);
            watched.setRemark(remark);
            watched.setFavorite(favorite);

            dao.update(watched);

            response.sendRedirect("assistidos");

            return;
        }

        if (params.equals("deletar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            WatchedDAO dao = new WatchedDAO();
            Watched watched = dao.getById(id);

            dao.delete(watched);

            response.sendRedirect("assistidos");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
