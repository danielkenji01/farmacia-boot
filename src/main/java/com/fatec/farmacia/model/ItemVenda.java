package com.fatec.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM_VENDA")
public class ItemVenda {

    @Id
    private int id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

    private BigDecimal valorUnitario;

    private int quantidade;

    private BigDecimal valorTotal;

}
