package com.iesvc.acceso.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RepoStock extends JpaRepository<Stock, String> {
	Stock findById( @Param("id") int id);
	
}
