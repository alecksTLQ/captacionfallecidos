package com.example.springsocial.process;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsocial.crud.CRUD;
import com.example.springsocial.generic.CrudController;
import com.example.springsocial.model.CabeceraFolioModell;
import com.example.springsocial.repository.CabeceraFolioRepository;
import com.example.springsocial.repository.ElementRepository;
import com.example.springsocial.repository.EntitiRepository;
import com.example.springsocial.tools.RestResponse;
import com.example.springsocial.transaction.CabeceraFolioTransaction;


@SuppressWarnings({"rawtypes", "unchecked","unused"})
public class CabeceraFolioProcess implements CrudController{
	
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	private CabeceraFolioRepository rpCabeceraFolio;
	private ElementRepository elementRepository;
	private EntitiRepository entitiRepository;
	
	private String moduloName = "CabeceraFolioModell";
	private CabeceraFolioTransaction mdlTransaction = new CabeceraFolioTransaction();
	RestResponse response = new RestResponse();
	private CRUD crud = new CRUD();
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		if(entityManagerFactory!=null) {
			this.entityManagerFactory = entityManagerFactory;
		}
	}
	
	@PostConstruct
    private void init() {
    	crud.setRepository(this.rpCabeceraFolio);
    	crud.setModelName(this.moduloName);
    	crud.setEntitiRepository(this.entitiRepository);
    	crud.setElementRepository(this.elementRepository);
    	repositories.put(this.moduloName, this.rpCabeceraFolio);
    }
	
	public String createCabecera(CabeceraFolioModell mdlFolio, EntityManagerFactory entityManagerFactory) {
		String respuesta =  null;
		try {
			mdlTransaction.setEntityManagerFactory(entityManagerFactory);
			mdlTransaction.save(mdlFolio);
			
			if(mdlTransaction.GetResponse().getError()!=null)throw new Exception(mdlTransaction.GetResponse().getError().toString());
				else {
				respuesta = "Insercion correcta";
			}
		}catch(Exception e) {
			respuesta= e.getMessage();
		}
		
		return respuesta;
		
	}
	
	public String updateCabecera(CabeceraFolioModell mdlFolio, EntityManagerFactory entityManagerFactory) {
		String respuesta = null;
		 try {
			mdlTransaction.setEntityManagerFactory(entityManagerFactory);
			mdlTransaction.update(mdlFolio);
			
			if(mdlTransaction.GetResponse().getError()!=null) throw new Exception(mdlTransaction.GetResponse().getError().toString());
				else {
				respuesta = "Insercion correcta";
			}
			 
		 }catch(Exception e) {
			 respuesta = e.getMessage();
		 }
		return respuesta;
	}
	
}
