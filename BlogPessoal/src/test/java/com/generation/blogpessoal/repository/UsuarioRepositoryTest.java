package com.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0L, "Giovanna Marques", "giovanna@email.com.br", "13465278"));
		
		usuarioRepository.save(new Usuario(0L, "Gabriella Marques", "gabriella@email.com.br", "13465278"));
		
		usuarioRepository.save(new Usuario(0L, "Thamires Santos", "thamires@email.com.br", "13465278"));

        usuarioRepository.save(new Usuario(0L, "Christina Melo", "christina@email.com.br", "13465278"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.FindByUsuario("giovanna@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("giovanna@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Giovanna Marques"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Gabriella Marques"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Thamires Santos"));
		
	}

}