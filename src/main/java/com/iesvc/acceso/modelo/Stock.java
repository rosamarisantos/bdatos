package com.iesvc.acceso.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@Table(name="stock")
@NamedQuery(name="Stock.findAll", 
            query="SELECT s FROM Stock s")
@NamedQuery(name = "Stock.findById", 
            query = "SELECT s FROM Stock s WHERE s.id= :id")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cantidad;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	@JoinColumn(name="ubicacion")
	@JsonBackReference
	//@JsonIgnore
	//private Ubicacion ubicacionBean;
	private Ubicacion ubicacion;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	@JsonBackReference
	//@JsonIgnore
	private Producto producto;

	public Stock() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
/*
 *public Ubicacion getUbicacionBean() {
		return this.ubicacionBean;
	}

	public void setUbicacionBean(Ubicacion ubicacionBean) {
		this.ubicacionBean = ubicacionBean;
	} 
 * 
 */
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}