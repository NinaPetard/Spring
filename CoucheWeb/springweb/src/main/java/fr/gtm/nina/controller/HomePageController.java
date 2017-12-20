package fr.gtm.nina.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.gtm.nina.domaine.Employe;
import fr.gtm.nina.service.EmployeManager;

public class HomePageController extends AbstractController {

	private EmployeManager employeManager;

	public void setEmployeManager(EmployeManager employeManager) {
		this.employeManager = employeManager;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Employe> employees = employeManager.getAllEmployes();
		
		return new ModelAndView("home", "employes", employees);

	}

}
