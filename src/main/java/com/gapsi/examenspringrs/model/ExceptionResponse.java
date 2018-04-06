package com.gapsi.examenspringrs.model;

import java.util.Date;

public class ExceptionResponse {
	
	private Date fecha;
	private String mensaje;
	private String detalles;
	
	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date fecha, String mensaje, String detalles) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [fecha=" + fecha + ", mensaje=" + mensaje + ", detalles=" + detalles + "]";
	}
	
	

}
