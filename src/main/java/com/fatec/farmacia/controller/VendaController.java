package com.fatec.farmacia.controller;

import com.fatec.farmacia.dto.VendaDTO;
import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.model.Venda;
import com.fatec.farmacia.service.ItemVendaService;
import com.fatec.farmacia.service.ProdutoService;
import com.fatec.farmacia.service.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class VendaController {

    private final ProdutoService produtoService;

    private final VendaService vendaService;

    private final ItemVendaService itemVendaService;

    public VendaController(ProdutoService produtoService,
                           VendaService vendaService,
                           ItemVendaService itemVendaService) {
        this.produtoService = produtoService;
        this.vendaService = vendaService;
        this.itemVendaService = itemVendaService;
    }

    @GetMapping("/venda")
    public String abrirTela(Model model) {
        model.addAttribute("vendaDTO", new VendaDTO());

        return "venda/form";
    }

    @GetMapping("/venda/{vendaId}")
    public String abrirVenda(@PathVariable Long vendaId,
                             Model model) {

        Optional<Venda> vendaOptional = vendaService.buscarPorId(vendaId);

        if (!vendaOptional.isPresent()) {
            return "redirect:/venda";
        }

        model.addAttribute("venda", vendaOptional.get());
        model.addAttribute("vendaDTO", new VendaDTO());

        return "venda/form";
    }

    @PostMapping("/venda/adicionar-produto")
    public String adicionarProduto(VendaDTO vendaDTO) {

        Optional<Produto> produtoOptional = produtoService.buscarProdutoPorId(vendaDTO.getProdutoId());

        if (!produtoOptional.isPresent()) {
            return "/venda";
        }

        Produto produto = produtoOptional.get();

        Venda venda = vendaService.salvar(vendaDTO.toVenda(produto));

        itemVendaService.salvar(vendaDTO.toItemVenda(
                produto,
                venda
        ));

        return String.format("reditect:/venda/%s", venda.getId());
    }


}