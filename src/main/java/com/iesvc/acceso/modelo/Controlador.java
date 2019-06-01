package com.iesvc.acceso.modelo;

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
	
	@Autowired
	RepoTipo repoTipo;
	
	@Autowired
	RepoAdmin repoAdmin;
	
	@Autowired
	RepoBitacora repoBitacora;
	
	@Autowired
	RepoProducto repoProducto;
	
	@Autowired
	RepoStock repoStock;
	
	@Autowired
	RepoUbicacion repoUbicacion;
	
	@Autowired
	RepoCategoria repoCategoria;
	
	
	@GetMapping ("/admin")
	public List<Administrador> getllAdmins(){
		return repoAdmin.findAll();
	}
	
	
	//Get All Bitacoras
	@GetMapping ("/bitacora")
	public List<Bitacora> getAllBitacoras(){
		return repoBitacora.findAll();
	}
	
	
	@GetMapping ("/tipo")
	public List<Tipo> getAllTipos(){
		return repoTipo.findAll();
	}
	
	
	@GetMapping ("/producto")
	public List<Producto> getllProductos(){
		return repoProducto.findAll();
	}
	
	
	//Get All Stocks
	@GetMapping ("/stock")
	public List<Stock> getAllStocks(){
		return repoStock.findAll();
	}
	
	
	@GetMapping ("/ubicacion")
	public List<Ubicacion> getAllUbicacions(){
		return repoUbicacion.findAll();
	}
	
	
	@GetMapping ("/categoria")
	public List<Categoria> getAllCategorias(){
		return repoCategoria.findAll();
	}
	

	// Get All Usuarios
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios() {
		return repoUsuario.findAll();
	}
}
