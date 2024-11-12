package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.atividade4.entity.ItemVenda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemVendaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<ItemVenda> DetalhesItemVenda(Long vendaId) {
        TypedQuery<ItemVenda> query = em.createQuery("SELECT iv FROM ItemVenda iv WHERE iv.venda.id = :vendaId", ItemVenda.class);
        query.setParameter("vendaId", vendaId);
        return query.getResultList();
    }
}