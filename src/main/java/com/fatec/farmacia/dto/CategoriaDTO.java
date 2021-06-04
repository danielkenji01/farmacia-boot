package com.fatec.farmacia.dto;

import com.fatec.farmacia.model.Categoria;

public class CategoriaDTO {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria() {
        return new Categoria()
                .comNome(this.nome);
    }

}