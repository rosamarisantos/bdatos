package com.iesvc.acceso.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCategoria extends JpaRepository<Categoria, String> {
	List<Categoria> findAllCategoria();
	Categoria findByNombre( @Param("nombre") String nombre);
}
