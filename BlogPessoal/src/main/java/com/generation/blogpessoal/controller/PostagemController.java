package com.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
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
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemrepository;
	
	@GetMapping
	public ResponseEntity<List<PostagemRepository>> getAll(){
		return ResponseEntity.ok(postagemrepository.findAll());
	}
	
	
    @GetMapping("/{id}")
    public ResponseEntity<PostagemRepository> GetById(@PathVariable long id){
        return postagemrepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

   
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<PostagemRepository>> GetByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(postagemrepository.findAllByTituloContainingIgnoreCase(titulo));
    }
    @PostMapping
    public ResponseEntity<PostagemRepository> post (@Valid @RequestBody Postagem postagem) {
    	return ResponseEntity.status(HttpStatus.CREATED).body(postagemrepository.save(postagemrepository));
    }
    @PutMapping
    public ResponseEntity<PostagemRepository> put (@Valid @RequestBody Postagem postagem) {
    	return ResponseEntity.status(HttpStatus.OK).body(postagemrepository.save(postagemrepository));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	postagemrepository.deleteById(id);
    }
}