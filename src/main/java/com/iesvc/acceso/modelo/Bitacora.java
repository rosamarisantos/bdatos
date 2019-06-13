package com.iesvc.acceso.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

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
/*
@NamedQuery(name = "Bitacora.findByUser", 
        query = "SELECT b FROM Bitacora b WHERE b.usuario=:usuario")
        */

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Bitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	
	//@CreatedDate
    //@Temporal(TemporalType.TIME)
	private Time hora;

   // @CreatedDate
   // @Temporal(TemporalType.DATE)
	private Date fecha;

	private String ip;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	@JsonBackReference
	private Usuario usuarioBean;


	public Bitacora() {
	}
    
	public Bitacora(Usuario usuarioBean, String ip) {
		this.ip = ip;
		this.usuarioBean=usuarioBean;
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