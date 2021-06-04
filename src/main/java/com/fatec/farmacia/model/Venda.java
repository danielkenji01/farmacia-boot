package com.fatec.farmacia.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "VENDA")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataVenda;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    public enum TipoPagamento {

        DINHEIRO,
        CARTAO_CREDITO,
        CARTAO_DEBITO;

    }

}