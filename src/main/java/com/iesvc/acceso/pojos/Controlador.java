package com.iesvc.acceso.pojos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class Controlador {
	@Autowired
	RepoUsuario repoUsuario;

	// Get All Usuarios
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios() {
		return repoUsuario.findAll();
	}
}
