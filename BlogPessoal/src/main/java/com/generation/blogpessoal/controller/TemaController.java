package com.generation.blogpessoal.controller;

import java.util.List;

import com.generation.blogpessoal.model.Tema;
import com.generation.blogpessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
	@Autowired
	private TemaRepository temarepository;
	
	@GetMapping
	public ResponseEntity<List<TemaRepository>> getAll(){
		return ResponseEntity.ok(temarepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TemaRepository> getById(@PathVariable long id){
		return temarepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/sobrenos/{sobrenos}")
	public ResponseEntity<List<TemaRepository>> getByName(@PathVariable String sobrenos){
		return ResponseEntity.ok(temarepository.findAllBySobrenosContainingIgnoreCase(sobrenos));
	}
	
	@PostMapping
	public ResponseEntity<TemaRepository> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temarepository.save(temarepository));
	}
	@PutMapping
	public ResponseEntity<TemaRepository> put (@RequestBody Tema tema){
		return ResponseEntity.ok(temarepository.save(temarepository));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		temarepository.deleteById(id);
	}
}