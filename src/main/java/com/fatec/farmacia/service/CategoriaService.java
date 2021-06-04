package com.fatec.farmacia.service;

import com.fatec.farmacia.model.Categoria;
import com.fatec.farmacia.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAllByDataExclusaoIsNull();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void excluir(Categoria categoria) {
        categoria.excluir();

        this.salvar(categoria);
    }

}