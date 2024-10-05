package com.ptgPactual.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptgPactual.demo.dao.BtgDao;
import com.ptgPactual.demo.dao.InversionDao;
import com.ptgPactual.demo.dto.BtgDto;
import com.ptgPactual.demo.dto.InversionDto;
import com.ptgPactual.demo.entity.Btgs;
import com.ptgPactual.demo.entity.Inversiones;
import com.ptgPactual.demo.utils.PtgExceptionHandler;

@Service
public class BtgServiceImpl implements BtgService {

	@Autowired
	private BtgDao btgDao;

	@Autowired
	private InversionDao inversionDao;

	@Override
	public BtgDto create(BtgDto btgDto) {
		Btgs btg = new Btgs();
		btg.toBtg(btgDto);
		return btgDao.save(btg).toBtgDTO();
	}

	@Override
	public InversionDto createInversion(InversionDto inversionDto) {
		String idUnico = LocalDate.now().toString();
		idUnico = idUnico.replace("-", "");
		LocalTime hora = LocalTime.now();
		String horas = hora.toString();
		horas = horas.replace("T", "");
		horas = horas.replace(":", "");
		horas = horas.replace(".", "");
		idUnico = idUnico.concat(horas);
		idUnico = idUnico.concat(inversionDto.getIdentificacion().toString());
		Inversiones inversion = new Inversiones();
		inversion.toInversion(inversionDto);
		inversion.setFecha(LocalDate.now());
		inversion.setIdUnico(idUnico);

		Btgs btg = new Btgs();
		btg = btgDao.findByIdentificacion((inversionDto.getIdentificacion()));

		if (btg.getMonto() < inversion.getMonto()) {
			throw new PtgExceptionHandler("no hay fondo suficiente para este monto");

		}

		switch (inversion.getFondo()) {

		case "FPV_BTG_PACTUAL_RECAUDADORA": {

			if (inversionDto.getMonto() > 75000) {
				btg.setMonto(btg.getMonto() - inversionDto.getMonto());
			}
			break;
		}
		case "FPV_BTG_PACTUAL_ECOPETROL": {

			if (inversionDto.getMonto() > 125000) {
				btg.setMonto(btg.getMonto() - inversionDto.getMonto());
			}
			break;
		}
		case "DEUDAPRIVADA": {
			if (inversionDto.getMonto() > 50000) {
				btg.setMonto(btg.getMonto() - inversionDto.getMonto());
			}
			break;
		}
		case "FDO-ACCIONES": {
			if (inversionDto.getMonto() > 250000) {
				btg.setMonto(btg.getMonto() - inversionDto.getMonto());
			}
			break;
		}
		case "FPV_BTG_PACTUAL_DINAMICA": {
			if (inversionDto.getMonto() > 100000) {
				btg.setMonto(btg.getMonto() - inversionDto.getMonto());
			}
		}

		default:

		}

		btgDao.save(btg);
		inversion.setEstado("Activo");
		return inversionDao.save(inversion).toInversionDTO();

	}

	@Override
	public List<InversionDto> getInveriones() {
		return inversionDao.findAll().stream().map(x -> x.toInversionDTO()).toList();
	}

	@Override
	public List<InversionDto> getInverionesActivas() {
		List<InversionDto> list=inversionDao.findByEstado("Activo").stream().map(x -> x.toInversionDTO()).toList();
		list =list.stream().filter(x-> x.getEstado().equals("Activo")).toList();
		return list;
	}

	@Override
	public InversionDto getByIdUnico(String id) {
		return inversionDao.findByIdUnico(id).toInversionDTO();
	}

	@Override
	public void deleteByIdUnico(String idUnico) {
		
		InversionDto inversionesDto = inversionDao.findByIdUnico(idUnico).toInversionDTO();
		inversionesDto.setEstado("Cancelado");
		
		Inversiones inversion = new Inversiones();
	    inversion.toInversion(inversionesDto);		
		inversionDao.save(inversion).toInversionDTO();

	}

	@Override
	public BtgDto getByIdentificacion(String Identificacion) {		
		return btgDao.findByIdentificacion(Identificacion).toBtgDTO();
	}



}
