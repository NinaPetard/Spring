package fr.gtm.nina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.nina.dao.IEmployeDao;
import fr.gtm.nina.domaine.Employe;

@Service
public class EmployeService {
	@Autowired
	private IEmployeDao employeDao;	



	public void printEmployebyId(int id) {
		Employe emp;	
		emp = employeDao.getEmployeById(id);
		System.out.println("Le nom de l'employé est "+ emp.getNom() );
				
	}

}
