package com.ptgPactual.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptgPactual.demo.dto.BtgDto;
import com.ptgPactual.demo.dto.InversionDto;
import com.ptgPactual.demo.service.BtgService;


@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping("/btg")
public class btgController {

	@Autowired
	private BtgService btgService;

	@PostMapping("/apertura")
	public ResponseEntity<?> apertura(@RequestBody BtgDto btgDto) {
		btgDto = btgService.create(btgDto);
		return new ResponseEntity<BtgDto>(btgDto, HttpStatus.CREATED);
	}

	@PostMapping("/inversiones")
	public ResponseEntity<?> inversiones(@RequestBody InversionDto inversionesDto) {
		inversionesDto = btgService.createInversion(inversionesDto);
		return new ResponseEntity<InversionDto>(inversionesDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/inversiones")
	public ResponseEntity<?> getInveriones() {
		List<InversionDto> listaInversion=new ArrayList<InversionDto>();
		listaInversion=btgService.getInveriones();		
		 	return new ResponseEntity<List<InversionDto>>( listaInversion, HttpStatus.CREATED);
	}
	
	@GetMapping("/inversiones/activa")
	public ResponseEntity<?> getInverionesActiva() {
		List<InversionDto> listaInversion=new ArrayList<InversionDto>();
		listaInversion=btgService.getInverionesActivas();		
		 	return new ResponseEntity<List<InversionDto>>( listaInversion, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/inversiones/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		if (btgService.getByIdUnico(id) != null) {
			
			InversionDto inversion=btgService.getByIdUnico(id);
			BtgDto btgDto= btgService.getByIdentificacion(inversion.getIdentificacion());
			btgDto.setMonto(btgDto.getMonto()+inversion.getMonto());
			btgService.create(btgDto);
			btgService.deleteByIdUnico(id);
		}
		return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
	}



}
