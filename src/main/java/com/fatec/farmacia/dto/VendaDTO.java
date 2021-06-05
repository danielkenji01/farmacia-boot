package com.fatec.farmacia.dto;

import com.fatec.farmacia.model.ItemVenda;
import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.model.Venda;

public class VendaDTO {

    private Long produtoId;

    private int quantidade;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda toVenda(Produto produto) {
        return new Venda()
                .comStatus(Venda.Status.EM_ANDAMENTO)
                .comValorTotal(produto.getPreco())
                .comDataVenda();
    }

    public ItemVenda toItemVenda(Produto produto,
                                 Venda venda) {
        return new ItemVenda()
                .comProduto(produto)
                .comVenda(venda)
                .comValorUnitario(produto.getPreco())
                .comQuantidade(this.quantidade)
                .calcularValorTotal();
    }

    public ItemVenda toItemVenda(ItemVenda itemVenda) {
        return itemVenda
                .comQuantidade(this.quantidade)
                .calcularValorTotal();
    }

}