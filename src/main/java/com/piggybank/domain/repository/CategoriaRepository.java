package com.piggybank.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piggybank.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
