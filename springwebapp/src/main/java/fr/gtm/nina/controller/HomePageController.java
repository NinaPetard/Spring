package fr.gtm.nina.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.gtm.nina.domaine.Employe;
import fr.gtm.nina.service.EmployeManager;
@Controller
public class HomePageController {
	
	@Autowired
	private EmployeManager employeManager;

	public void setEmployeManager(EmployeManager employeManager) {
		this.employeManager = employeManager;
	}


	@RequestMapping(value="/", method=RequestMethod.GET)
	protected ModelAndView listeEmployes(HttpServletRequest request, HttpServletResponse response) throws Exception {
	List<Employe> listeEmployes = employeManager.getAllEmployes();
	return new ModelAndView("home", "employes", listeEmployes);
	}

	

}
