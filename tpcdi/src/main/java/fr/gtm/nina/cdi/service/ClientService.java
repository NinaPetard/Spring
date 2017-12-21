package fr.gtm.nina.cdi.service;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import fr.gtm.nina.cdi.dao.IClientDao;

public class ClientService {
	
	@Inject
	IClientDao dao;
	
	public String creerClient() {
		return "Service : "+dao.insertClient();
	}
	
	@PostConstruct
	public void logapresConstruction() {
		System.out.println("Après Création Service");
	}
	
	

}
