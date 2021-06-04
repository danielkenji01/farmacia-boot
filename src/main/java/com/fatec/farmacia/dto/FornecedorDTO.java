package com.fatec.farmacia.dto;

import com.fatec.farmacia.model.Categoria;
import com.fatec.farmacia.model.Fornecedor;

public class FornecedorDTO {

    private String nome;

    private String endereco;

    public FornecedorDTO() {}

    public FornecedorDTO(Fornecedor fornecedor) {
        this.nome = fornecedor.getNome();
        this.endereco = fornecedor.getEndereco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Fornecedor toFornecedor(Fornecedor fornecedor) {
        return fornecedor.comNome(this.nome).comEndereco(this.endereco);
    }

    public Fornecedor toFornecedor() {
        return new Fornecedor()
                .comNome(this.nome)
                .comEndereco(this.endereco);
    }

}