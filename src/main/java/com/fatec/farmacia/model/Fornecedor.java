package com.fatec.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor {

    @Id
    private Long id;

    private String nome;

    private String endereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Fornecedor comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Fornecedor comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

}