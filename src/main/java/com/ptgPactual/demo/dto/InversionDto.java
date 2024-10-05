package com.ptgPactual.demo.dto;

import java.time.LocalDate;

public class InversionDto {
	
	private String idUnico;
	private String identificacion;
	private String fondo;
	private Integer monto;
	private String estado;
	private  LocalDate fecha;
	
	
	
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getIdUnico() {
		return idUnico;
	}
	public void setIdUnico(String idUnico) {
		this.idUnico = idUnico;
	}
	public String getFondo() {
		return fondo;
	}
	public void setFondo(String fondo) {
		this.fondo = fondo;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
 
}
