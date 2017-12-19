package fr.gtm.nina.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.gtm.nina.domaine.Employe;

public class EmployeDao2 implements IEmployeDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	
	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id, login, password, prenom, nom,"
	+"email, role) values(?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(EMPLOYE_INSERT, new Object[] {
				employe.getId(), employe.getLogin(), employe.getPassword(), employe.getPrenom(),
				employe.getNom(), employe.getEmail(), employe.getRole()});
				
		}
	
	public int getEmployesCount() {
		final String EMPLOYE_COUNT = "SELECT Count(*) from employe";		
		int res = jdbcTemplate.queryForObject(EMPLOYE_COUNT, Integer.class);		
		return res;
	}
	
	public Employe getEmployeById(int id) {
		Employe employe;
		final String EMPLOYE_BY_ID = "Select * from employe where id= ?";
		employe = jdbcTemplate.queryForObject(EMPLOYE_BY_ID, new Object[] { id },		
				new BeanPropertyRowMapper<Employe>(Employe.class));
		return employe;		
	};
	
	public Employe getEmployebyLogin(String login) {
		Employe employe;
		final String EMPLOYE_BY_LOGIN = "Select * from employe where login= ?";
		employe = jdbcTemplate.queryForObject(EMPLOYE_BY_LOGIN, new Object[] { login },		
		new BeanPropertyRowMapper<Employe>(Employe.class));
		return employe;
		
	};
	

	public List<Employe> getAllEmployes(){
		List<Employe> employes;
		final String ALL_EMPLOYES = "Select * from employe";
		employes = jdbcTemplate.query(ALL_EMPLOYES, new BeanPropertyRowMapper<Employe>(Employe.class));
		return employes;
		
		
	};
	
	//Employe employe = (Employe)getJdbcTemplate().queryForObject(
		//	sql, new Object[] { custId },
			


	
	}


