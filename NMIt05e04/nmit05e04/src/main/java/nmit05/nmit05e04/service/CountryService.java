package nmit05.nmit05e04.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import nmit05.nmit05e04.domain.Country;

@Data
@NoArgsConstructor
@Service
public class CountryService {

    private List<Country> countries = new ArrayList<>();

    public void loadCountriesFile()  {
		
		try {
            ClassPathResource resource = new ClassPathResource("static/paises.csv");

            Path path = resource.getFile().toPath();

            List<String> lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
 
            for (String linea : lineas) {
                String[] countryAttributes = linea.split(";"); 
                countries.add(new Country(countryAttributes[0], countryAttributes[1], countryAttributes[2])); 
            }
        } catch (IOException e) {
    
            System.err.println("Error reading the file: " + e.getMessage());
        }
        
    }

    public List<Country> getCountries(){
        return countries; 
    }

    public Country getCountry(String nameCountry){
        for (Country country : countries) {
            if (country.getName().equals(nameCountry)){
                return country; 
            }
        }
        return null; 
    }
}
