package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade4.entity.Pessoa;
import org.example.atividade4.entity.PessoaFisica;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public class PessoaFisicaRepository {


    @PersistenceContext
    private EntityManager em;

    public void save(PessoaFisica pessoaFisica) {
        em.persist(pessoaFisica);

    }
    public void update(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public List<PessoaFisica> list() {
        Query query = em.createQuery("from PessoaFisica ");
        return query.getResultList();
    }


    public void deleteId(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.remove(pessoa);
    }
    public PessoaFisica edit(Long id) {
        return em.find(PessoaFisica.class, id);
    }
}
