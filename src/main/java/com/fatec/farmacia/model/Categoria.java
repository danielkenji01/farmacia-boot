package com.fatec.farmacia.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataExclusao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public void excluir() {
        this.dataExclusao = new Date();
    }

}