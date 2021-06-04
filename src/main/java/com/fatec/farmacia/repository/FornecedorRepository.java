package com.fatec.farmacia.repository;

import com.fatec.farmacia.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    List<Fornecedor> findAllByDataExclusaoIsNull();

}