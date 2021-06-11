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

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public ItemVenda comProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public ItemVenda comVenda(Venda venda) {
        this.venda = venda;
        return this;
    }

    public ItemVenda comValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public ItemVenda comQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemVenda calcularValorTotal() {
        this.valorTotal = valorUnitario.multiply(BigDecimal.valueOf(quantidade));
        return this;
    }

}
