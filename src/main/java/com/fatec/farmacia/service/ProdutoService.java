package com.fatec.farmacia.service;

import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAllByDataExclusaoIsNull();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }

    public void excluir(Produto produto) {
        produtoRepository.excluirProduto(produto.getId());
    }

}