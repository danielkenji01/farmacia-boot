package com.fatec.farmacia.service;

import com.fatec.farmacia.model.Fornecedor;
import com.fatec.farmacia.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> buscarTodas() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void cadastrar(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

}