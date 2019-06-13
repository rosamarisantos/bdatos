package com.iesvc.acceso.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@Table(name="ubicacion")
@NamedQuery(name="Ubicacion.findAll", 
            query="SELECT u FROM Ubicacion u")
@NamedQuery(name = "Ubicacion.findById", 
            query = "SELECT u FROM Ubicacion u WHERE u.nombre= :nombre")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private String color;

	private String sector;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="ubicacion")
    @JsonManagedReference
	private List<Stock> stocks;

	public Ubicacion() {
	}
	

	public Ubicacion(String nombre, String color, String sector) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.sector = sector;
	}


	public Ubicacion(String nombre, String color, String sector, List<Stock> stocks) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.sector = sector;
		this.stocks = stocks;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	
	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setUbicacion(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setUbicacion(null);

		return stock;
	}

}