package fr.gtm.nina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.gtm.nina.dao.IEmployeDao;
import fr.gtm.nina.service.EmployeService;

@Configuration
public class ServiceConfig {
	
	//	<bean id="employeService" class="fr.gtm.nina.service.Employeservice"  autowire="byName">
	//<!-- <property name="employeDao" ref="employeDao" />-->
//</bean>
	
	@Bean("employeService")
	@Autowired
	public EmployeService employeService(IEmployeDao employeDao) {
		EmployeService employeService = new EmployeService();
		employeService.setEmployeDao(employeDao);
		return employeService;
		
	}

}
