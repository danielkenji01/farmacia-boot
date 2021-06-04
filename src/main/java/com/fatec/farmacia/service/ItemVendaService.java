package com.fatec.farmacia.service;

import com.fatec.farmacia.model.ItemVenda;
import com.fatec.farmacia.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public void salvar(ItemVenda itemVenda) {
        itemVendaRepository.save(itemVenda);
    }

}