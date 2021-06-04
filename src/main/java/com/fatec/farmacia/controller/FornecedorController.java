package com.fatec.farmacia.controller;

import com.fatec.farmacia.dto.FornecedorDTO;
import com.fatec.farmacia.model.Fornecedor;
import com.fatec.farmacia.service.FornecedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/fornecedores")
    public String buscarFornecedores(Model model) {

        model.addAttribute("fornecedores", fornecedorService.buscarTodas());

        return "fornecedor/lista";
    }

    @GetMapping("/fornecedores/novo")
    public String novaFornecedor(Model model) {

        model.addAttribute("fornecedorDTO", new FornecedorDTO());
        model.addAttribute("isEdicao", false);

        return "fornecedor/form";
    }

    @PostMapping("/fornecedores/novo")
    public String novaFornecedor(FornecedorDTO fornecedorDTO) {

        fornecedorService.cadastrar(
                fornecedorDTO.toFornecedor()
        );

        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/{fornecedorId}/editar")
    public String editarFornecedor(@PathVariable Long fornecedorId,
                                  Model model) {

        Optional<Fornecedor> fornecedorOptional = fornecedorService.buscarPorId(fornecedorId);

        if (!fornecedorOptional.isPresent()) {
            return "redirect:/fornecedores";
        }

        model.addAttribute("fornecedorDTO", new FornecedorDTO(fornecedorOptional.get()));
        model.addAttribute("isEdicao", true);

        return "fornecedor/form";
    }

    @PostMapping("/fornecedores/{fornecedorId}/editar")
    public String editarFornecedor(@PathVariable Long fornecedorId,
                                   FornecedorDTO fornecedorDTO) {

        Optional<Fornecedor> fornecedorOptional = fornecedorService.buscarPorId(fornecedorId);

        if (!fornecedorOptional.isPresent()) {
            return "redirect:/fornecedores";
        }

        fornecedorService.cadastrar(
                fornecedorDTO.toFornecedor(fornecedorOptional.get())
        );

        return "redirect:/fornecedores";
    }

}