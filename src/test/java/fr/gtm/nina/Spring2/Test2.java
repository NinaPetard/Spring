package fr.gtm.nina.Spring2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.nina.dao.IEmployeDao;
import fr.gtm.nina.domaine.Employe;
import junit.framework.TestCase;

public class Test2 extends TestCase {
	
	private Employe emp;
	private IEmployeDao springDao;
	private ClassPathXmlApplicationContext appContext;
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		emp=new Employe(7,"jean", "mdpobjis", "Jean", "DUPONT", "jean.dupont@objis.com", "employe");
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");
		
		springDao = (IEmployeDao) appContext.getBean("employeDao");
	};
	

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
		appContext = null;
		springDao = null;
			}
	
	public void testSaveEmploye() {
		springDao.saveEmploye(emp);
	}
	
	public void testGetEmployedById() {
		Employe employe = springDao.getEmployeById(2);
		assertNotNull(employe);
		
	}

}
