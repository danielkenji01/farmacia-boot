package com.fatec.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "VENDA")
public class Venda {

    @Id
    private int id;

    private Date dataVenda;

    private BigDecimal valorTotal;

    private String tipoPagamento; // TODO alterar para enum

}
