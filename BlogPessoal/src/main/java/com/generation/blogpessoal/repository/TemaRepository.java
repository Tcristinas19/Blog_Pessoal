package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<TemaRepository, Long> {
	public List<TemaRepository> findAllBySobrenosContainingIgnoreCase(String sobrenos);

}