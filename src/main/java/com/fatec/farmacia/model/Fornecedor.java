package com.fatec.farmacia.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    private Date dataExclusao;

    public Fornecedor() {

    }

    public Fornecedor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public Fornecedor comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Fornecedor comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public void excluir() {
        this.dataExclusao = new Date();
    }

}