package com.ptgPactual.demo.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtgDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String id;
	
	
	
	@JsonProperty
	private String identificacion;
	
	
	@JsonProperty
	private String nombres;
	
	
	@JsonProperty
	private String correo;

	
	@JsonProperty
	private String celular;
	
	
	@JsonProperty
	private Integer monto;
	


	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

}
