package fr.gtm.nina.Spring2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.nina.dao.EmployeDao;
import fr.gtm.nina.dao.EmployeDao2;
import fr.gtm.nina.domaine.Employe;
import fr.gtm.nina.service.Employeservice;

public class AppTest {

	private Employe emp;
	private String beanDataSource;
	private EmployeDao2 dao;
	private Employeservice serv;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] {"spring-data.xml"});
		
		emp = new Employe(5, "morad", "mdpobjis", "Morad", "HANAFI", "morad.hanafi@objis.com", "employe");
		dao = (EmployeDao2) appContext.getBean("employeDao");
		serv = (Employeservice) appContext.getBean("employeService");

	}

	@After
	public void tearDown() throws Exception {
		emp = null;
	}

	// save emp
	// @Test
	public void testSaveEmploye() {
		dao.saveEmploye(emp);
	}

	// get emp by id
	@Test
	public void testGetEmployeById() {
		Employe employe = dao.getEmployeById(2);
		assertNotNull(employe);
		assertEquals("Samb", employe.getNom());
	}

	// count emp
	@Test
	public void testCount() {
		int res = dao.getEmployesCount();
		assertEquals(5, res);
	}

	// get emp by tag

	@Test
	public void testGetEmployeByLogin() {
		Employe employe = dao.getEmployebyLogin("douglas");
		assertNotNull(employe);
		assertEquals("Mbiandou", employe.getNom());
	}
	
	@Test
	public void testGetAllEmployes() {
		List<Employe> employes = dao.getAllEmployes();
		assertNotNull(employes);
	}
	
	@Test
	public void testprintEmploye() {
		serv.printEmployebyId(2);
		
	}
	
	
}
