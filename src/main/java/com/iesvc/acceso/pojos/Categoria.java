package com.iesvc.acceso.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;

	private String descripcion;

	//bi-directional many-to-one association to Tipo
	@OneToMany(mappedBy="categoriaBean")
	private List<Tipo> tipos;

	public Categoria() {
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

	public List<Tipo> getTipos() {
		return this.tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public Tipo addTipo(Tipo tipo) {
		getTipos().add(tipo);
		tipo.setCategoriaBean(this);

		return tipo;
	}

	public Tipo removeTipo(Tipo tipo) {
		getTipos().remove(tipo);
		tipo.setCategoriaBean(null);

		return tipo;
	}

}