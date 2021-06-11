package com.fatec.farmacia.dto;

import com.fatec.farmacia.model.Categoria;
import com.fatec.farmacia.model.Fornecedor;
import com.fatec.farmacia.model.Produto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private String nome;
    private Integer preco;
    private Long categoriaId;
    private Long fornecedorId;

    public ProdutoDTO() {

    }

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco().intValue();
        this.categoriaId = produto.getCategoria() != null ? produto.getCategoria().getId() : null;
        this.fornecedorId = produto.getFornecedor() != null ? produto.getFornecedor().getId() : null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Long fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Produto produtoConverte() {
        return produtoConverte(new Produto());
    }

    public Produto produtoConverte(Produto produto) {
        produto.setNome(nome);
        produto.setPreco(BigDecimal.valueOf(preco));
        produto.setCategoria(new Categoria(categoriaId));
        produto.setFornecedor(new Fornecedor(fornecedorId));

        return produto;
    }

}