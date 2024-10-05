package com.ptgPactual.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ptgPactual.demo.entity.Inversiones;
import java.util.List;


public interface InversionDao extends MongoRepository<Inversiones, String>{ 
	
	
	 public List<Inversiones> findByEstado(String estado);
	 public Inversiones findByIdUnico(String unico);
	 void deleteByIdUnico(String unico);
	
	
	

}
