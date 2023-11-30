package com.ifrs.moviebox.dao;

import com.ifrs.moviebox.models.MovieStreaming;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MovieStreamingDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public MovieStreamingDAO() {}

    public void create(MovieStreaming movieStreaming) {
        em.getTransaction().begin();
        em.persist(movieStreaming);
        em.getTransaction().commit();
    }

    public MovieStreaming getById(long id) {
        return em.find(MovieStreaming.class, id);
    }

    public List<MovieStreaming> getAll() {
        TypedQuery<MovieStreaming> query = em.createQuery("SELECT g FROM MovieStreaming g", MovieStreaming.class);
        return query.getResultList();
    }

    public void update(MovieStreaming movieStreaming) {
        em.getTransaction().begin();
        em.merge(movieStreaming);
        em.getTransaction().commit();
    }

    public void delete(MovieStreaming movieStreaming) {
        em.getTransaction().begin();
        em.remove(movieStreaming);
        em.getTransaction().commit();
    }
}
