package fr.gtm.nina.Spring2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.gtm.nina.config.DaoConfig;
import fr.gtm.nina.config.ServiceConfig;
import fr.gtm.nina.dao.EmployeDao2;
import fr.gtm.nina.domaine.Employe;
import fr.gtm.nina.service.EmployeService;

public class AppTest {

	private Employe emp;
	private EmployeDao2 dao;
	private EmployeService serv;
	private JdbcTemplate jdbcT;

	@Before
	public void setUp() throws Exception {

		ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(DaoConfig.class,
				EmployeService.class);

		emp = new Employe(5, "morad", "mdpobjis", "Morad", "HANAFI", "morad.hanafi@objis.com", "employe");
		dao = (EmployeDao2) appContext.getBean("employeDao");
		serv = (EmployeService) appContext.getBean("employeService");
		jdbcT =(JdbcTemplate) appContext.getBean("jdbcTemplate");

	}

	@After
	public void tearDown() throws Exception {
			emp = null;

	}

	// save emp
	//@Test
	public void testSaveEmploye() {
		dao.saveEmploye(emp);
	}

	// get emp by id

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
	public void testGetEmployeById() {
		Employe employe = dao.getEmployeById(2);
		assertNotNull(employe);
		assertEquals("Samb", employe.getNom());
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
