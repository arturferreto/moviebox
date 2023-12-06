package com.ifrs.moviebox.dao;

import com.ifrs.moviebox.models.Watched;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class WatchedDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public WatchedDAO() {}

    public void create(Watched watched) {
        em.getTransaction().begin();
        em.persist(watched);
        em.getTransaction().commit();
    }

    public Watched getById(long id) {
        return em.find(Watched.class, id);
    }

    public List<Watched> getAll() {
        TypedQuery<Watched> query = em.createQuery("SELECT g FROM Watched g", Watched.class);
        return query.getResultList();
    }

    public void update(Watched watched) {
        em.getTransaction().begin();
        em.merge(watched);
        em.getTransaction().commit();
    }

    public void delete(Watched watched) {
        em.getTransaction().begin();
        em.remove(watched);
        em.getTransaction().commit();
    }

    public void deleteByMovieId(long movieId) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Watched w WHERE w.moviesByMovieId.id = :movieId")
                .setParameter("movieId", movieId)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
