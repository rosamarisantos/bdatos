package com.iesvc.acceso.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the tipo database table.
 * 
 */
@Entity
@Table(name="tipo")
@NamedQuery(name="Tipo.findAll", 
            query="SELECT t FROM Tipo t")
@NamedQuery(name = "Tipo.findByNombre", 
            query = "SELECT t FROM Tipo t WHERE t.nombre= :nombre")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private String descripcion;
	/*
	//bi-directional many-to-one association to Usuario
		@ManyToOne
		@JoinColumn(name="usuario")
		@JsonBackReference
		private Usuario usuarioBean;
*/
	//bi-directional many-to-one association to Producto
	@OneToMany( cascade = CascadeType.ALL, mappedBy="tipoBean")
	@JsonManagedReference
	private List<Producto> productos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria")
	@JsonBackReference
	private Categoria categoriaBean;

	public Tipo() {
	}

	
	public Tipo(String nombre, String descripcion, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
		
	}


	public Tipo(String nombre) {
		super();
		this.nombre = nombre;
		
	}
	
	public Tipo(String nombre, String descripcion, List<Producto> productos, Categoria categoriaBean) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
		this.categoriaBean = categoriaBean;
	}


	public Tipo(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setTipoBean(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setTipoBean(null);

		return producto;
	}
	
	

	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

}