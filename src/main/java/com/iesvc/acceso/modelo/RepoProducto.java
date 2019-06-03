package com.iesvc.acceso.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RepoProducto extends JpaRepository<Producto, String> {
	Producto findById( @Param("id") int id);
	List<Producto> findByNombre( @Param("nombre") String nombre);
}
