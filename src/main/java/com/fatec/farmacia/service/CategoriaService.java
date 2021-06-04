package com.fatec.farmacia.service;

import com.fatec.farmacia.model.Categoria;
import com.fatec.farmacia.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    public void cadastrar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

}