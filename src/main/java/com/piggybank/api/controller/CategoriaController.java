package com.piggybank.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.piggybank.api.services.CategoriaService;
import com.piggybank.domain.model.Categoria;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("categoria")
public class CategoriaController {
	private CategoriaService categoriaService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Categoria> list() {
		return categoriaService.list();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria get(@PathVariable("id") long id) {
		Optional<Categoria> categoriaData = categoriaService.get(id);
		
		if (!categoriaData.isPresent()) {
			return null;
		}
		
		return categoriaData.get();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria update(@PathVariable("id") long id, @RequestBody Categoria categoria) {
		Optional<Categoria> categoriaData = categoriaService.get(id);
		
		if (categoriaData.isPresent()) {
			Categoria _categoria = categoriaData.get();
			_categoria.setNome(categoria.getNome());
			_categoria.setDescricao(categoria.getDescricao());
			return categoriaService.save(_categoria);
		}
		
		return null;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable("id") long id) {
		categoriaService.delete(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaService.save(categoria);
    }
}
