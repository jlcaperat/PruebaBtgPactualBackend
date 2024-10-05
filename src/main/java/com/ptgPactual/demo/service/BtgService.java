package com.ptgPactual.demo.service;

import java.util.List;

import com.ptgPactual.demo.dto.BtgDto;
import com.ptgPactual.demo.dto.InversionDto;

public interface BtgService {
	
	
	public BtgDto create(BtgDto btgDto);
	public BtgDto getByIdentificacion(String Identificacion);
	public InversionDto createInversion(InversionDto inversionDto);
	public List<InversionDto> getInveriones();
	public List<InversionDto> getInverionesActivas();
	public InversionDto getByIdUnico(String id);
	public void deleteByIdUnico(String id);
	

}
