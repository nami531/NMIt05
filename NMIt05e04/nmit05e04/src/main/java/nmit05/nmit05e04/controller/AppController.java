package nmit05.nmit05e04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nmit05.nmit05e04.domain.Country;
import nmit05.nmit05e04.service.CountryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AppController {
    
    @Autowired
    private CountryService cs; 

    @GetMapping({" ", "/", "/index"})
    public String showIndex(Model model) {
        model.addAttribute("country", new Country()); 
        model.addAttribute("countries", cs.getCountries());
        return "indexView";
    }

    @PostMapping("/submit")
    public String proccessCountry(Country country, Model model) {
        model.addAttribute("country", country); 
        model.addAttribute("countries", cs.getCountries());
        model.addAttribute("selectedCountry", cs.getCountry(country.getName())); 
        return "indexView";
    }
    
    
}
