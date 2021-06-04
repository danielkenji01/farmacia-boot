package com.fatec.farmacia.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEM_VENDA")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

    private BigDecimal valorUnitario;

    private int quantidade;

    private BigDecimal valorTotal;

}
