package com.fatec.farmacia.service;

import com.fatec.farmacia.model.Venda;
import com.fatec.farmacia.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public void calcularValorTotal(Venda venda) {
        venda.calcularValorTotal();

        this.salvar(venda);
    }

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

}