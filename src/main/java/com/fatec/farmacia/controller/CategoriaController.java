package com.fatec.farmacia.controller;

import com.fatec.farmacia.dto.CategoriaDTO;
import com.fatec.farmacia.model.Categoria;
import com.fatec.farmacia.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public String buscarCategorias(Model model) {

        List<Categoria> categorias = categoriaService.buscarTodas();

        model.addAttribute("categorias", categorias);

        return "categoria/lista";
    }

    @GetMapping("/categorias/novo")
    public String novaCategoria(Model model) {

        model.addAttribute("categoriaDTO", new CategoriaDTO());
        model.addAttribute("isEdicao", false);

        return "categoria/form";
    }

    @PostMapping("/categorias/novo")
    public String novaCategoria(CategoriaDTO categoriaDTO) {

        Categoria categoria = categoriaDTO.toCategoria();

        categoriaService.salvar(categoria);

        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{categoriaId}/editar")
    public String editarCategoria(@PathVariable Long categoriaId,
                                  Model model) {

        Optional<Categoria> categoriaOptional = categoriaService.buscarPorId(categoriaId);

        if (!categoriaOptional.isPresent()) {
            return "redirect:/categorias";
        }

        model.addAttribute("categoriaDTO", new CategoriaDTO(categoriaOptional.get()));
        model.addAttribute("isEdicao", true);

        return "categoria/form";
    }

    @PostMapping("/categorias/{categoriaId}/editar")
    public String editarCategoria(@PathVariable Long categoriaId,
                                  CategoriaDTO categoriaDTO) {

        Optional<Categoria> categoriaOptional = categoriaService.buscarPorId(categoriaId);

        if (!categoriaOptional.isPresent()) {
            return "redirect:/categorias";
        }

        categoriaService.salvar(
                categoriaDTO.toCategoria(categoriaOptional.get())
        );

        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{categoriaId}/excluir")
    public String excluirCategoria(@PathVariable Long categoriaId) {

        Optional<Categoria> categoriaOptional = categoriaService.buscarPorId(categoriaId);

        if (!categoriaOptional.isPresent()) {
            return "redirect:/categorias";
        }

        categoriaService.excluir(categoriaOptional.get());

        return "redirect:/categorias";
    }

}