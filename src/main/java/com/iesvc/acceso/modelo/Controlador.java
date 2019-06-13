package com.iesvc.acceso.modelo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "*")
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
	
	// Get Admin
	@GetMapping("/admin/{id}")
	public Administrador getAdminById(@PathVariable(value = "id") String username) {
		Administrador admin = repoAdmin.findById(username).get();
		if (admin == null)
			admin = new Administrador();
		return admin;
	}

	// Post Admin
	@PostMapping(value = "/admin", consumes = { "application/json" })
	@ResponseBody
	public Administrador createAdmin(@Valid @RequestBody Administrador admin) {
		return repoAdmin.save(admin);
	}

	// Update Admin
	@PutMapping(value = "/admin/{id}", consumes = { "application/json" })
	@ResponseBody
	public Administrador updateAdministrador(@PathVariable(value = "id") String administradorId,
		@Valid @RequestBody Administrador administrador) {
		Administrador new_administrador = repoAdmin.findById(administradorId).orElseThrow();
		new_administrador.setEmail(administrador.getEmail());
		new_administrador.setPassword(administrador.getPassword());
		new_administrador.setTelefono(administrador.getTelefono());
		return repoAdmin.save(new_administrador);
	}

	// Delete Admin
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteAdministrador(@PathVariable(value = "id") String administradorId) {
		Administrador administrador = repoAdmin.findById(administradorId).orElseThrow();

		repoAdmin.delete(administrador);

		return ResponseEntity.ok().build();
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
  
   //No funciona ni desde bitacora tampoco-----------------------------
    //Post Bitacora 
   /* @PostMapping(value="/usuario/{username}/bitacora", consumes= {"application/json"})
   	@ResponseBody public Usuario createBitacora( @PathVariable (value="bitacora")  @RequestBody Bitacora bitacora) {
   	System.out.println("Intent guardar Bitacora");	
   	return repoUsuario.save(bitacora);
   	}
   	*/
   	
    @PostMapping(value = "/bitacora", consumes = { "application/json" })
	@ResponseBody
	public @Valid Bitacora createBitacora(@Valid @RequestBody Bitacora bitacora) {
		return repoBitacora.save(bitacora);
	}  
    
   // Delete Bitacora
 	@DeleteMapping("/bitacora/{id}")
 	public ResponseEntity<?> deleteBitacora(@PathVariable(value = "id") int bitacoraId) {
 		Bitacora bitacora = repoBitacora.findById(bitacoraId);

 		repoBitacora.delete(bitacora);

 		return ResponseEntity.ok().build();
 	}
 	
 	//UpdateBitacora   La bitacora no se puede modificar
 
    //------------------------------TIPOS---------------------------------------------
	
	//Get All Tipos
	@GetMapping ("/tipo")
	public List<Tipo> getAllTipos(){
		return repoTipo.findAll();
	}
	
    @GetMapping("/tipo/{nombre}")
    public Tipo getTipoById(@PathVariable(value = "nombre") String nombreId) {
        return repoTipo.findByNombre(nombreId);
               
    }
	 
	// Post Tipo NO VA ????????????????????????????????????????????????????????????????????????????????????????????
	@PostMapping(value = "/tipo", consumes = { "application/json" })
	@ResponseBody
	public Tipo createTipo(@Valid @RequestBody Tipo tipo) {
		return repoTipo.save(tipo);
	}
	
	
	// Delete Tipo
	@DeleteMapping("/tipo/{nombre}")
	public ResponseEntity<?> deleteTipo(@PathVariable(value = "nombre") String tipoId) {
		Tipo tipo = repoTipo.findByNombre(tipoId);

		repoTipo.delete(tipo);
		
		return ResponseEntity.ok().build();
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
    
 // Post Producto NO VA ???????????????????????????????????????????????????????????????????????????????????????????????
 	@PostMapping(value = "/producto", consumes = { "application/json" })
 	@ResponseBody public Producto createProducto(@Valid @RequestBody Producto producto) {
 		return repoProducto.save(producto);
 	}
    
 // Delete Producto
 	@DeleteMapping("/producto/{id}")
 	public ResponseEntity<?> deleteProducto(@PathVariable(value = "id") int productoId) {
 		Producto producto = repoProducto.findById(productoId);

 		repoProducto.delete(producto);

 		return ResponseEntity.ok().build();
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
	 
	 
	 
	 
	 
	 
	 
	 
	 
	// Post Stock NO VA ??????????????????????????????????????????????????????????????????????????????????????
	@PostMapping(value = "/stock", consumes = { "application/json" })
	@ResponseBody
	public Stock createStock(@Valid @RequestBody Stock stock) {
		return repoStock.save(stock);
	}
	 
	
	
	
	
	
	
	
	
  // Delete Stock
	@DeleteMapping("/stock/{id}")
	public ResponseEntity<?> deleteStock(@PathVariable(value = "id") int stockId) {
		Stock stock = repoStock.findById(stockId);

		repoStock.delete(stock);

		return ResponseEntity.ok().build();
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
	   //Post Ubicacion NO VA ????????????????????????????????????????????????????????????????????????????????????
		@PostMapping(value = "/ubicacion", consumes = { "application/json" })
		@ResponseBody  public Ubicacion createUbicacion(@Valid @RequestBody Ubicacion ubicacion) {
			return repoUbicacion.save(ubicacion);
		}
	 
	 
	// Delete Ubicacion
	@DeleteMapping("/ubicacion/{nombre}")
	public ResponseEntity<?> deleteUbicacion(@PathVariable(value = "nombre") String nombreId) {
		Ubicacion ubicacion = repoUbicacion.findByNombre(nombreId);

		repoUbicacion.delete(ubicacion);

		return ResponseEntity.ok().build();
	}
	//----------------------------------CATEGORIA--------------------------------------
	
	//Get All Categoría
	@GetMapping ("/categoria")
	public List<Categoria> getAllCategorias(){
		return repoCategoria.findAllCategoria();
	}

    @GetMapping("/categoria/{nombre}")
    public Categoria getCategoria(@PathVariable(value = "nombre") String nombre) {
        return repoCategoria.findByNombre(nombre);
               
    }
    
    @PostMapping(value="/categoria", consumes= {"application/json"})
	@ResponseBody public Categoria createCategoria(@Valid @RequestBody Categoria categoria) {
	return repoCategoria.save(categoria);
	}
    
 // Delete Categoria
  	@DeleteMapping("/categoria/{nombre}")
  	public ResponseEntity<?> deleteCategoria(@PathVariable(value = "nombre") String nombreId) {
  		Categoria categoria = repoCategoria.findByNombre(nombreId);

  		repoCategoria.delete(categoria);

  		return ResponseEntity.ok().build();
  	}
  	
  	
  	
 
	//-------------------------------------------USUARIOS-------------------------------------

	// Get All Usuarios
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios() {
		return repoUsuario.findAll();
	}
	
	
	// Get All Bitacoras de un Usuario
		@GetMapping("/usuario/{username}/bitacora")
		public List<Bitacora> getAllBitacora(@PathVariable (value="username") String username) {
			java.util.Optional<Usuario> usuario =repoUsuario.findById(username);
			return usuario.get().getBitacoras();
		}
	
	 @GetMapping("/usuario/{username}")
	    public Usuario getUsuario(@PathVariable(value = "username") String username) {
	        return repoUsuario.findByNombre(username);
	               
	    }
	
	 
	 @PostMapping(value="/usuario", consumes= {"application/json"})
		@ResponseBody public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		System.out.println("Intent guardar Usuario");	
		return repoUsuario.save(usuario);
		
		
		}
	 
	// Update Usuario
		@PutMapping(value = "/usuario/{username}", consumes = { "application/json" })
		@ResponseBody
		public Usuario updateUsuario(@PathVariable(value = "username") String usuarioId,
			@Valid @RequestBody Usuario usuario) {
			Usuario new_usuario = repoUsuario.findById(usuarioId).orElseThrow();
			new_usuario.setEmail(usuario.getEmail());
			new_usuario.setPasswd(usuario.getPasswd());
			return repoUsuario.save(new_usuario);
		}
		
	
	 
	// Delete Usuario
	@DeleteMapping("/usuario/{username}")
	public ResponseEntity<?> deleteUsuario(@PathVariable(value = "username") String usuarioId) {
		Usuario usuario = repoUsuario.findByNombre(usuarioId);

		repoUsuario.delete(usuario);

		return ResponseEntity.ok().build();
	}
	 
	 
	 	
	 	
	
}
