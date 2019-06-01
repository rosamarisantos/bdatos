package com.iesvc.acceso.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RepoTipo extends JpaRepository<Tipo, String> {
	Tipo findByNombre( @Param("nombre") String  nombre);
}
