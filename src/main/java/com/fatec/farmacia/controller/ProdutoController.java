package com.fatec.farmacia.controller;

import com.fatec.farmacia.dto.ProdutoDTO;
import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.service.CategoriaService;
import com.fatec.farmacia.service.FornecedorService;
import com.fatec.farmacia.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProdutoController {
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;
    private final FornecedorService fornecedorService;

    public ProdutoController(ProdutoService produtoService,
                             CategoriaService categoriaService,
                             FornecedorService fornecedorService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.buscarTodos();
        model.addAttribute("produtos", produtos);
        return "produtos/lista";
    }

    @GetMapping("/produtos/novo")
    public String adicionaProduto(Model model) {
        model.addAttribute("produtoDTO", new ProdutoDTO());
        model.addAttribute("isEdicao", false);
        model.addAttribute("categorias", categoriaService.buscarTodas());
        model.addAttribute("fornecedores", fornecedorService.buscarTodas());
        return "produtos/form";
    }

    @PostMapping("/produtos/novo")
    public String adicionaProduto(ProdutoDTO produtoDTO) {
        produtoService.salvar(produtoDTO.produtoConverte());
        return "redirect:/produtos";
    }

    @GetMapping("/produtos/{produtoId}/editar")
    public String editarProduto(@PathVariable Long produtoId,
                                Model model) {

        Optional<Produto> produtoOptional = produtoService.buscarPorId(produtoId);

        if (!produtoOptional.isPresent()) {
            return "redirect:/produtos";
        }

        model.addAttribute("produtoDTO", new ProdutoDTO(produtoOptional.get()));
        model.addAttribute("isEdicao", true);
        model.addAttribute("categorias", categoriaService.buscarTodas());
        model.addAttribute("fornecedores", fornecedorService.buscarTodas());

        return "produtos/form";
    }

    @PostMapping("/produtos/{produtoId}/editar")
    public String editarProduto(@PathVariable Long produtoId,
                                ProdutoDTO produtoDTO) {

        Optional<Produto> produtoOptional = produtoService.buscarPorId(produtoId);

        if (!produtoOptional.isPresent()) {
            return "redirect:/produtos";
        }

        produtoService.salvar(produtoDTO.produtoConverte(produtoOptional.get()));

        return "redirect:/produtos";
    }

    @GetMapping("/produtos/{produtoId}/excluir")
    public String excluirProduto(@PathVariable Long produtoId) {

        Optional<Produto> produtoOptional = produtoService.buscarPorId(produtoId);

        if (!produtoOptional.isPresent()) {
            return "redirect:/produtos";
        }

        produtoService.excluir(produtoOptional.get());

        return "redirect:/produtos";
    }

}