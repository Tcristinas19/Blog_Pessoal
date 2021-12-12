package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemRepository, Long>{
	public List<PostagemRepository> findAllByTituloContainingIgnoreCase (String titulo);

}