package com.iesvc.acceso.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;






/**
 * The persistent class for the bitacora database table.
 * 
 */
@Entity
@Table(name="bitacora")
@NamedQuery(name="Bitacora.findAll", 
            query="SELECT b FROM Bitacora b")
@NamedQuery(
		name = "Bitacora.findById", 
		query = "SELECT b FROM Bitacora b WHERE b.id = :id")
@NamedQuery(
		name = "Bitacora.findByFecha", 
		query = "SELECT b FROM Bitacora b WHERE b.fecha = :fecha")

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Bitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Time hora;


	private Date fecha;

	private String ip;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	@JsonBackReference
	private Usuario usuarioBean;

	public Bitacora() {
	}
    
	public Bitacora(int id, Time hora, Date fecha, String ip) {
		super();
		this.id = id;
		this.hora = hora;
		this.fecha = fecha;
		this.ip = ip;
	}
	
	

	public Bitacora(Time hora, Date fecha, String ip) {
		super();
		this.hora = hora;
		this.fecha = fecha;
		this.ip = ip;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}



}