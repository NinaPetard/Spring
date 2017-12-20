package fr.gtm.nina.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource("classpath:/fr/gtm/nina/config/db.properties")
@ComponentScan(basePackages = "fr.gtm.nina.dao")
public class DaoConfig {
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${db.driver}")
	private String driverClassName;
	
	@Bean("dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		
		return dataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean("jdbcTemplate")
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);		
		return jdbcTemplate;	
	}

}