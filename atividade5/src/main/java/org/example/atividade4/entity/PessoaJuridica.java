package org.example.atividade4.entity;

import jakarta.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {

    private String cnpj;
    private String razaoSocial;


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    @Override
    public String getCpf() {
        return null; // PessoaJuridica does not have a CPF, so return null or throw an UnsupportedOperationException
    }
    @Override
    public String getNome() {
        return null; // PessoaJuridica does not have a CPF, so return null or throw an UnsupportedOperationException
    }
}
