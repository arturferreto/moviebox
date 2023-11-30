package com.ifrs.moviebox.dao;

import com.ifrs.moviebox.models.Movies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MovieDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public MovieDAO() {}

    public void create(Movies movie) {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
    }

    public Movies getById(long id) {
        return em.find(Movies.class, id);
    }

    public List<Movies> getAll() {
        TypedQuery<Movies> query = em.createQuery("SELECT g FROM Movies g", Movies.class);
        return query.getResultList();
    }

    public void update(Movies movie) {
        em.getTransaction().begin();
        em.merge(movie);
        em.getTransaction().commit();
    }

    public void delete(Movies movie) {
        em.getTransaction().begin();
        em.remove(movie);
        em.getTransaction().commit();
    }
}
