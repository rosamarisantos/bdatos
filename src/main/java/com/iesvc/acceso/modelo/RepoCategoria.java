package com.iesvc.acceso.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RepoCategoria extends JpaRepository<Categoria, String> {
	Categoria findByNombre( @Param("nombre") String nombre);
}
