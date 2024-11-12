package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade4.entity.Venda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Venda> ListVendas() {
        Query query = em.createQuery("from Venda ");
        return query.getResultList();
    }

    public Venda DetailVenda(Long id) {
        Query query = em.createQuery("from Venda where id = :id");
        query.setParameter("id", id);
        return (Venda) query.getSingleResult();
    }

}
