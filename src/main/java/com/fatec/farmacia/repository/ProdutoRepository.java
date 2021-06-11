package com.fatec.farmacia.repository;

import com.fatec.farmacia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call excluir_produto(:produtoId)")
    void excluirProduto(@Param("produtoId") Long produtoId);

    List<Produto> findAllByDataExclusaoIsNull();

}