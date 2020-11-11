package br.salaoEveris.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.salaoEveris.app.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);

}
