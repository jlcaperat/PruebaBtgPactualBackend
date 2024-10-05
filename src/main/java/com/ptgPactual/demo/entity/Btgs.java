package com.ptgPactual.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ptgPactual.demo.dto.BtgDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Btgs {

	@Id
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

	public String getNombres() {
		return nombres;
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

	public String getNombre() {
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

	public void toBtg(BtgDto btgDto) {


		this.setId(btgDto.getId());
		this.setIdentificacion(btgDto.getIdentificacion());		
		this.setNombres(btgDto.getNombres());
		this.setCorreo(btgDto.getCorreo());
		this.setCelular(btgDto.getCelular());
		this.setMonto(btgDto.getMonto());

	}

	public BtgDto toBtgDTO() {

		BtgDto btgDTO = new BtgDto();

		btgDTO.setId(id);
	    btgDTO.setIdentificacion(identificacion);
		btgDTO.setNombres(nombres);
		btgDTO.setCorreo(correo);
		btgDTO.setCelular(celular);
		btgDTO.setMonto(monto);
		return btgDTO;

	}

}
