package com.fatec.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor {

    @Id
    private int id;

    private String nome;

    private String endereco;

}