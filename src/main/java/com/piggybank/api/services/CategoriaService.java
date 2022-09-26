package com.piggybank.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.piggybank.domain.model.Categoria;
import com.piggybank.domain.repository.CategoriaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaService {
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> list() {
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> get(long id) {
		Optional<Categoria> categoriaData = categoriaRepository.findById(id);

		return categoriaData;
	}
	
	public Categoria save(Categoria categoriaData) {
		return categoriaRepository.save(categoriaData);
	}
	
	public boolean delete(long id) {
		try {
			categoriaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
