package fr.gtm.nina.service;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.nina.dao.IEmployeDao;
import fr.gtm.nina.domaine.Employe;

public class EmployeManager implements IEmployeManager{
	
	private IEmployeDao employeDao;
	
	public void setEmployeDao(IEmployeDao employeDao) {
		this.employeDao=employeDao;
	}
	
	public Employe getEmploye(String login) {
		Employe employe = employeDao.getEmployebyLogin(login);
		return employe;
	}
	
	public Employe getEmploye(int id) {
		Employe employe = employeDao.getEmployeById(id);
		return employe;
	}
	
	public List<Employe> getAllEmployes(){
		List<Employe> employees = new ArrayList<Employe>();
		employees = (List<Employe>) employeDao.getAllEmployes();
		return employees;
	}
	
	
	

}
