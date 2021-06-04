package com.fatec.farmacia.controller;

import com.fatec.farmacia.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}