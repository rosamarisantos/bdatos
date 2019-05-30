package com.iesvc.acceso.pojos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsuario extends JpaRepository<Usuario, String> {
	
public List<Usuario> findByEmail(String email);
//public List<Usuario> findByNombre(String nombre);

	

}
