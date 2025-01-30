package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade4.entity.Venda;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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


    public List<Venda> buscarData(LocalDate data) {
        Query query = em.createQuery("from Venda v where v.data = :data");
        query.setParameter("data", data);
        return query.getResultList();
    }

    public List<Venda> buscarCliente(Long id) {
        Query query = em.createQuery("from Venda v where v.pessoa.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Venda> buscarNomeCliente(String nome) {
        Query query = em.createQuery("from Venda v where lower(v.pessoa.nome) ilike :nome");
        query.setParameter("nome", nome.toLowerCase());
        return query.getResultList();
    }

    public void save(Venda venda) {
        em.persist(venda);
    }
}
