package com.fatec.farmacia.controller;

import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public String listarProdutos (Model model) {
        List<Produto> produtos = produtoService.buscarTodos();
        model.addAttribute("produtos",produtos);
        return "produtos/lista";
    }
}
