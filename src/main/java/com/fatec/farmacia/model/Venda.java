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

    @Enumerated(EnumType.STRING)
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

    public Venda calcularValorTotal() {
        this.valorTotal = BigDecimal.ZERO;

        for (ItemVenda itemVenda : itemVendaList) {
            this.valorTotal = this.valorTotal.add(itemVenda.getValorTotal());
        }

        return this;
    }

    public boolean isEmAndamento() {
        return Status.EM_ANDAMENTO.equals(this.status);
    }

    public void finalizarVenda(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        this.status = Status.FINALIZADA;
    }

    public enum TipoPagamento {
        DINHEIRO("Dinheiro"),
        CARTAO_CREDITO("Cartão de crédito"),
        CARTAO_DEBITO("Cartão de débito");

        private final String descricao;

        TipoPagamento(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum Status {
        EM_ANDAMENTO("Em andamento"),
        FINALIZADA("Finalizada"),
        CANDELADA("Cancelada");

        private final String descricao;

        Status(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

}