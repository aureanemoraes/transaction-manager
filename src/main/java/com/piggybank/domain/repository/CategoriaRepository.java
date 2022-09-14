package com.piggybank.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.piggybank.domain.model.Categoria;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Integer>{
	List<Categoria> list();
}
