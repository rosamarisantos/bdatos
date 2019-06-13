package com.iesvc.acceso.modelo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, String> {
	
public List<Usuario> findByEmail(String email);
Usuario findByNombre(String username);
public Usuario save(@Valid Bitacora bitacora);

	

}
