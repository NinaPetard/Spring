package fr.gtm.nina.service;

import fr.gtm.nina.dao.IEmployeDao;
import fr.gtm.nina.domaine.Employe;

public class EmployeService {
	
	private IEmployeDao employeDao;	
	
	public void setEmployeDao(IEmployeDao employeDao) {
		this.employeDao = employeDao;
	}



	public void printEmployebyId(int id) {
		Employe emp;	
		emp = employeDao.getEmployeById(id);
		System.out.println("Le nom de l'employé est "+ emp.getNom() );
				
	}

}
