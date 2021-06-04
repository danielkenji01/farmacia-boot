package com.fatec.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    private int id;

    private String nome;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Fornecedor fornecedor;

    private BigDecimal preco;

}