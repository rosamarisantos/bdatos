package com.iesvc.acceso.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//-----------------------------------ADMINISTRADOR---------------------------------
	
	//Get All Admins
	@GetMapping ("/admin")
	public List<Administrador> getllAdmins(){
		return repoAdmin.findAll();
	}
	
	//Get Admin
		@GetMapping ("/admin/{id}")
		public Administrador getAdminById(@PathVariable(value="id") String username){
			Administrador admin= repoAdmin.findById(username).get();
			if(admin==null) admin=new Administrador();
			return admin;
		}
		
	
	//------------------------------BITACORA-----------------------------------------	
		
	//Get All Bitacoras
	@GetMapping ("/bitacora")
	public List<Bitacora> getAllBitacoras(){
		return repoBitacora.findAll();
	}
		
    //Get id Bitacora
    @GetMapping("/bitacora/{id}")
    public Bitacora getBitacoraById(@PathVariable(value = "id") int bitacoraId) {
        return repoBitacora.findById(bitacoraId);
               
    }
 
    //------------------------------TIPOS---------------------------------------------
	
	//Get All Tipos
	@GetMapping ("/tipo")
	public List<Tipo> getAllTipos(){
		return repoTipo.findAll();
	}
	//Get id Tipo
	 @GetMapping("/tipo/{nombre}")
	    public Tipo getTipo(@PathVariable(value = "nombre") String nombre) {
	        return repoTipo.findByNombre(nombre);
	               
    }
	 
	 
	//--------------------------------PRODUCTOS------------------------------------------- 
	 
	
	//Get All Productos
	@GetMapping ("/producto")
	public List<Producto> getllProductos(){
		return repoProducto.findAll();
	}
	
	 
    @GetMapping("/producto/nombre/{nombre}")
    public List<Producto> getProducto(@PathVariable(value = "nombre") String nombre) {
        return repoProducto.findByNombre(nombre);
              
    }
    
    @GetMapping("/producto/{id}")
    public Producto getProductoId(@PathVariable(value = "id") int id) { 
        return repoProducto.findById(id);
              
    }
 
 //-----------------------------------STOKS--------------------------------------------
	
	
	//Get All Stocks
	@GetMapping ("/stock")
	public List<Stock> getAllStocks(){
		return repoStock.findAll();
	}
	
	 @GetMapping("/stock/{id}")
	    public Stock getStock(@PathVariable(value = "id") int stockId) {
	        return repoStock.findById(stockId);
	               
	    }
	 
	//-----------------------------------UBICACION------------------------------------
	
	//Get All Ubicación
	@GetMapping ("/ubicacion")
	public List<Ubicacion> getAllUbicacions(){
		return repoUbicacion.findAll();
	}
	
	
	 @GetMapping("/ubicacion/{nombre}")
	    public Ubicacion getUbicacion(@PathVariable(value = "nombre") String nombre) {
	        return repoUbicacion.findByNombre(nombre);
	               
	    }
	
	
	
	//----------------------------------CATEGORIA--------------------------------------
	
	//Get All Categoría
	@GetMapping ("/categoria")
	public List<Categoria> getAllCategorias(){
		return repoCategoria.findAll();
	}
	
	 
    @GetMapping("/categoria/{nombre}")
    public Categoria getCategoria(@PathVariable(value = "nombre") String nombre) {
        return repoCategoria.findByNombre(nombre);
               
    }
 
	//-------------------------------------------USUARIOS-------------------------------------

	// Get All Usuarios
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios() {
		return repoUsuario.findAll();
	}
	
	
	 @GetMapping("/usuario/{username}")
	    public Usuario getUsuario(@PathVariable(value = "username") String username) {
	        return repoUsuario.findByNombre(username);
	               
	    }
	
	
	
}
