package org.example.atividade4.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
public class Venda implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Date data;

    @ManyToOne
    private Pessoa pessoa;




    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
    private List<ItemVenda> itensVenda;

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double total() {
        double total = 0;
        for (ItemVenda itemVenda : itensVenda) {
            total += itemVenda.total();
        }
        return total;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}