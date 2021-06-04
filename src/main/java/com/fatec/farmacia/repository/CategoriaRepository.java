package com.fatec.farmacia.repository;

import com.fatec.farmacia.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByDataExclusaoIsNull();

}