package com.fatec.farmacia.service;

import com.fatec.farmacia.model.ItemVenda;
import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.model.Venda;
import com.fatec.farmacia.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public Optional<ItemVenda> buscarPorVendaEProduto(Venda venda, Produto produto) {
        return itemVendaRepository.findOneByVendaAndProduto(venda, produto);
    }

    public void salvar(ItemVenda itemVenda) {
        itemVendaRepository.save(itemVenda);
    }

}