package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade4.entity.Produto;
import org.example.atividade4.entity.Venda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Produto produto) {
        em.persist(produto);
    }

    public void update(Produto produto) {
        em.merge(produto);
    }

    public void deleteId(Long id) {
        Produto produto = em.find(Produto.class, id);
        em.remove(produto);
    }

    public List<Produto> buscarProduto(String descricao) {
        String nomeProduto = descricao.toLowerCase();
        Query query = em.createQuery("select p from Produto p where lower(p.descricao) like :descricao");
        query.setParameter("descricao", "%" + nomeProduto + "%");
        return query.getResultList();
    }

    public Produto edit(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> ListProduto() {
        Query query = em.createQuery("from Produto ");
        return query.getResultList();
    }

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public Produto produto(Long produtoId) {
        return em.find(Produto.class, produtoId);
    }
}
