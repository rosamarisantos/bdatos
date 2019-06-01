package com.iesvc.acceso.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsuario extends JpaRepository<Usuario, String> {
	
public List<Usuario> findByEmail(String email);
Usuario findByNombre(String username);

	

}
