package com.ifrs.moviebox.dao;

import com.ifrs.moviebox.models.Streamings;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StreamingDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();

    public StreamingDAO() {}

    public void create(Streamings streaming) {
        em.getTransaction().begin();
        em.persist(streaming);
        em.getTransaction().commit();
    }

    public Streamings getById(long id) {
        return em.find(Streamings.class, id);
    }

    public List<Streamings> getAll() {
        TypedQuery<Streamings> query = em.createQuery("SELECT g FROM Streamings g", Streamings.class);
        return query.getResultList();
    }

    public void update(Streamings streaming) {
        em.getTransaction().begin();
        em.merge(streaming);
        em.getTransaction().commit();
    }

    public void delete(Streamings streaming) {
        em.getTransaction().begin();
        em.remove(streaming);
        em.getTransaction().commit();
    }
}
