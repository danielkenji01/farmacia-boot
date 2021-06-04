package com.fatec.farmacia.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

    private Status status;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
    private List<ItemVenda> itemVendaList;

    public Long getId() {
        return id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Status getStatus() {
        return status;
    }

    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public Venda comValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Venda comStatus(Status status) {
        this.status = status;
        return this;
    }

    public Venda comDataVenda() {
        this.dataVenda = new Date();
        return this;
    }

    public enum TipoPagamento {
        DINHEIRO,
        CARTAO_CREDITO,
        CARTAO_DEBITO;
    }

    public enum Status {
        EM_ANDAMENTO,
        FINALIZADA,
        CANDELADA;
    }

}