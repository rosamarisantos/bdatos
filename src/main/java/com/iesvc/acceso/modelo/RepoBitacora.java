package com.iesvc.acceso.modelo;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoBitacora extends JpaRepository<Bitacora, String> {
	Bitacora findById( @Param("id") int  id);
	
	
}
