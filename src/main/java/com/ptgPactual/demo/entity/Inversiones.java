package com.ptgPactual.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptgPactual.demo.dto.BtgDto;
import com.ptgPactual.demo.dto.InversionDto;

import jakarta.persistence.Entity;


@Entity
public class Inversiones {
	
	@JsonProperty
	private String idUnico;
	@JsonProperty
	private String identificacion;

	@JsonProperty
	private String fondo;
	@JsonProperty
	private Integer monto;
	@JsonProperty
	private String estado;
	@JsonProperty
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
	
	public void toInversion(InversionDto inversionDto) {
		this.idUnico=inversionDto.getIdUnico();
		this.fondo=inversionDto.getFondo();
		this.monto=inversionDto.getMonto();
		this.fecha=inversionDto.getFecha();
		this.estado=inversionDto.getEstado();
		this.identificacion=inversionDto.getIdentificacion();
		
	}
	
	
	public InversionDto toInversionDTO() {
		
		InversionDto inversionDto = new InversionDto();
		inversionDto.setIdUnico(idUnico);
		inversionDto.setIdentificacion(identificacion);
		inversionDto.setFondo(fondo);
		inversionDto.setEstado(estado);
		inversionDto.setMonto(monto);
		inversionDto.setFecha(fecha);

		return inversionDto;
		
	}
}
