package nmit05.nmit05e04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nmit05.nmit05e04.service.CountryService;

@SpringBootApplication
public class Nmit05e04Application {


	public static void main(String[] args) {
		SpringApplication.run(Nmit05e04Application.class, args);
		
		
	}

	@Bean
	CommandLineRunner initData(CountryService cs) {
	return args -> {
		cs.loadCountriesFile();
	};
	}

}
