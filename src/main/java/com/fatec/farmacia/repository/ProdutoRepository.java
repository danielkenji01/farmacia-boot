package com.fatec.farmacia.repository;

import com.fatec.farmacia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}