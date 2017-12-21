package fr.gtm.nina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.nina.dao.IEmployeDao;
import fr.gtm.nina.domaine.Employe;

@Service("employeManager")
public class EmployeManager implements IEmployeManager {
	
	@Autowired
	private IEmployeDao employeDao;	
	
	
	public void setEmployeDao(IEmployeDao employeDao) {
		this.employeDao = employeDao;
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
		List<Employe> allEmployees = (List<Employe>) employeDao.getAllEmployes();
		return allEmployees;
	}
	

}
