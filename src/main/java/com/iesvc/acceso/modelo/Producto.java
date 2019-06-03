package com.iesvc.acceso.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", 
           query="SELECT p FROM Producto p")
@NamedQuery(name = "Producto.findById", 
           query = "SELECT p FROM Producto p WHERE p.id= :id")
@NamedQuery(name = "Producto.findByNombre", 
           query = "SELECT p FROM Producto p WHERE p.nombre= :nombre")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String marca;

	private String modelo;

	private String nombre;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="tipo")
	@JsonBackReference
	private Tipo tipoBean;

	//bi-directional many-to-one association to Stock
	@OneToMany( cascade = CascadeType.ALL, mappedBy="producto")
	@JsonManagedReference
	private List<Stock> stocks;

	public Producto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipoBean() {
		return this.tipoBean;
	}

	public void setTipoBean(Tipo tipoBean) {
		this.tipoBean = tipoBean;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProducto(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProducto(null);

		return stock;
	}

	

}