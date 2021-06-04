package com.fatec.farmacia.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    private BigDecimal preco;

    private Date dataExclusao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }
}