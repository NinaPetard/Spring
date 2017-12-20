package fr.gtm.nina.dao;

import java.util.List;

import fr.gtm.nina.domaine.Employe;

public interface IEmployeDao {
	
	public Employe getEmployeById(int id);
	public Employe getEmployebyLogin(String login);
	public void saveEmploye(Employe employe);
	public int getEmployesCount();
	public List<Employe> getAllEmployes();

}
