package com.fatec.farmacia.service;

import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    public List<Produto> buscarTodos() {

        return produtoRepository.findAll();
    }
    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }
}
