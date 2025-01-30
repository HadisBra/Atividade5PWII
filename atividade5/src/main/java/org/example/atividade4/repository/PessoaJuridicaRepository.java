package org.example.atividade4.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.atividade4.entity.Pessoa;
import org.example.atividade4.entity.PessoaFisica;
import org.example.atividade4.entity.PessoaJuridica;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaJuridicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(PessoaJuridica pessoajuridica) {
        em.persist(pessoajuridica);

    }
    public void updatePJ(Pessoa pessoa) {
        em.merge(pessoa);
    }

    public List<PessoaJuridica> buscarRazaoSocial(String razaoSocial) {
        String razaoSocialJuridica = razaoSocial.toLowerCase();
        Query query = em.createQuery("select j from PessoaJuridica j where lower(j.razaoSocial) like :razaoSocial");
        query.setParameter("razaoSocial", "%" + razaoSocialJuridica + "%");
        return query.getResultList();
    }

    public List<PessoaJuridica> list() {
        Query query = em.createQuery("from PessoaJuridica ");
        return query.getResultList();
    }


    public void deleteId(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.remove(pessoa);
    }
    public PessoaJuridica edit(Long id) {
        return em.find(PessoaJuridica.class, id);
    }

    public PessoaJuridica pessoaJuridica(Long id) {
        return em.find(PessoaJuridica.class, id);
    }
}
