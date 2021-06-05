package com.fatec.farmacia.repository;

import com.fatec.farmacia.model.ItemVenda;
import com.fatec.farmacia.model.Produto;
import com.fatec.farmacia.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

    Optional<ItemVenda> findOneByVendaAndProduto(Venda venda, Produto produto);

}