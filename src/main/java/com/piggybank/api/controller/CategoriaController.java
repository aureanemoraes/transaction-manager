package com.piggybank.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piggybank.domain.model.Categoria;
import com.piggybank.domain.repository.CategoriaRepository;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> index() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Categoria show(@PathVariable("id") long id) {
		Optional<Categoria> categoriaData = categoriaRepository.findById(id);
		
		if (categoriaData.isPresent()) {
			return categoriaData.get();
		}
	
		return null;
	}
	
	@PutMapping("/{id}")
	public Categoria update(@PathVariable("id") long id, @RequestBody Categoria categoria) {
		Optional<Categoria> categoriaData = categoriaRepository.findById(id);
		
		if (categoriaData.isPresent()) {
			Categoria _categoria = categoriaData.get();
			_categoria.setNome(categoria.getNome());
			_categoria.setDescricao(categoria.getDescricao());
			return categoriaRepository.save(_categoria);
		}
		
		return null;
	}
	
	/*
	 * 
	 * @DeleteMapping("/tutorials/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      tutorialRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
	 */
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) {
		try {
			categoriaRepository.deleteById(id);
			return "Success.";
		} catch (Exception e) {
			return "Error.";
		}
	}
	
	@PostMapping
    public Categoria store(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
