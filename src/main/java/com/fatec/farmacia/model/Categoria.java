package com.fatec.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    private int id;

    private String nome;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}