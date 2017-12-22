package fr.gtm.nina.springfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringfullApplication {
    
    @RequestMapping("/")
    String home(){
        return "LALALA";
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringfullApplication.class, args);
	}
}
