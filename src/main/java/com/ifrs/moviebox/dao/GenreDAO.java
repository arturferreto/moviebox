package com.ifrs.moviebox.dao;

import com.ifrs.moviebox.models.Genres;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GenreDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public GenreDAO() {}

    public void create(Genres genre) {
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
    }

    public Genres getById(long id) {
        return em.find(Genres.class, id);
    }

    public List<Genres> getAll() {
        TypedQuery<Genres> query = em.createQuery("SELECT g FROM Genres g", Genres.class);
        return query.getResultList();
    }

    public void update(Genres genre) {
        em.getTransaction().begin();
        em.merge(genre);
        em.getTransaction().commit();
    }

    public void delete(Genres genre) {
        em.getTransaction().begin();
        em.remove(genre);
        em.getTransaction().commit();
    }
}
