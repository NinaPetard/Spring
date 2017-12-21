package fr.gtm.nina.cdi.dao;
import javax.annotation.PostConstruct;


public class JdbcClientDao implements IClientDao {
	
	public String insertClient() {
		return "Creation client en BDD jdbc pur ok";
	}
	
	@PostConstruct
	public void logapresConstruction() {
		System.out.println("Après création ClientDao");
	}

}
