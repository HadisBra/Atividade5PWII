package org.example.atividade4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class PessoaFisica  extends Pessoa implements Serializable {

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
    public String getDadosPessoa() {
        return  nome;
    }
}
