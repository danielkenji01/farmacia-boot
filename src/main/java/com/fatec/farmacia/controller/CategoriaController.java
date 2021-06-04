package com.fatec.farmacia.controller;

import com.fatec.farmacia.dto.CategoriaDTO;
import com.fatec.farmacia.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public String buscarCategorias(Model model) {

        model.addAttribute("categorias", categoriaService.buscarTodas());

        return "categoria/lista";
    }

    @GetMapping("/categorias/novo")
    public String novaCategoria(Model model) {

        model.addAttribute("categoriaDTO", new CategoriaDTO());

        return "categoria/form";
    }

    @PostMapping("/categorias/novo")
    public String novaCategoria(CategoriaDTO categoriaDTO) {

        categoriaService.cadastrar(
                categoriaDTO.toCategoria()
        );

        return "redirect:/categorias";

    }

}