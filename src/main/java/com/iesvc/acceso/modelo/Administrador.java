package com.iesvc.acceso.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
@NamedQuery(name="Administrador.findAll", 
            query="SELECT a FROM Administrador a")
@NamedQuery(
		name = "Administrador.findById", 
		query = "SELECT a FROM Administrador a WHERE a.id = :id")

public class Administrador {
@Id	
private String username;
private String password;
private String email;
private Long telefono;

public Administrador() {
	
}

public Administrador(String username, String password, String email, Long telefono) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.telefono = telefono;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getTelefono() {
	return telefono;
}

public void setTelefono(Long telefono) {
	this.telefono = telefono;
}


}
