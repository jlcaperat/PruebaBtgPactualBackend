package com.ptgPactual.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ptgPactual.demo.entity.Btgs;
import java.util.List;




@Repository
public interface BtgDao extends MongoRepository<Btgs, String>{
	
	
	 public  Btgs findByIdentificacion(String identificacion);

}
