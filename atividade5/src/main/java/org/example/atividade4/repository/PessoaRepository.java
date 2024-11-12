package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.atividade4.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Pessoa> ListPessoas() {
        return em.createQuery("from Pessoa").getResultList();
    }

}
