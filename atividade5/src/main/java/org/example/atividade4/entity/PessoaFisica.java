package org.example.atividade4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class PessoaFisica  extends Pessoa {

    private String cpf;
    private String nome;



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String getCnpj() {
        return null; // PessoaFisica does not have a CNPJ, so return null or throw an UnsupportedOperationException
    }
    @Override
    public String getRazaoSocial() {
        return null; // PessoaFisica does not have a CNPJ, so return null or throw an UnsupportedOperationException
    }
}
