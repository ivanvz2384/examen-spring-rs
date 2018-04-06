package com.gapsi.examenspringrs.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Todo lo relacionado a los articulos")
@Entity
@Table(name = "articulos")
public class Articulo {
	
	@Id
	@Column(updatable=false)
	@Size(max=10, message="El id debe de ser de maximo 10 caracteres")
	@ApiModelProperty(notes = "Clave de maximo 10 caracteres")
	private String id;
	@Column(updatable=false)
	@Size(max=20, message="El nombre debe de ser de maximo 20 caracteres")
	@ApiModelProperty(notes = "Nombre maximo 20 caracteres")
	private String nombre;
	@Size(max=200, message="La descripcion debe de ser de maximo 200 caracteres")
	@ApiModelProperty(notes = "Descripcion maximo 200 caracteres")
	private String descripcion;
	@Column(updatable=false)
	@Positive(message ="El precio debe de ser mayor a cero")
	@ApiModelProperty(notes = "Precio del articulo debe de ser positivo")
	private BigDecimal precio;
	@Size(max=10, message="El modelo debe de ser de maximo 10 caracteres")
	@ApiModelProperty(notes = "Modelo del articulo de maximo 10 caracteres")
	private String modelo;
	
	public Articulo() {
		super();
	}

	public Articulo(String id, String nombre, String descripcion, BigDecimal precio, String modelo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.modelo = modelo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", modelo=" + modelo + "]";
	}
	
	
	

}
