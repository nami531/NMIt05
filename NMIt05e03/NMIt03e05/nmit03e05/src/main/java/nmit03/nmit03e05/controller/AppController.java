package nmit03.nmit03e05.controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import nmit03.nmit03e05.domain.MovieForm;
import nmit03.nmit03e05.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class AppController {
    
    @Autowired
    private MovieService service; 
    
    private boolean added = false; 
    
    @GetMapping({"/", " ", "/index"})
    public String showIndex(Model model) {   
        if (!added){
            service.addMovie("Avatar"); 
            service.addMovie("Bohemian-Rhapsody"); 
            service.addMovie("Star-Wars_The-force-awakes");
            added=true; 
        }  
        model.addAttribute("movies", service.getMovies()); 
        model.addAttribute("movieForm", new MovieForm()); 
        return "index";
    }

    @PostMapping("/submit")
    public String voteForm(@Valid MovieForm movieForm, BindingResult bindingResult, Model model ) {
        model.addAttribute("movieForm", movieForm);
        if (bindingResult.hasErrors()){
            // List<ObjectError> errors = bindingResult.getAllErrors(); 
            // ArrayList<String> errorMessages = new ArrayList<>(); 
            // for (ObjectError error : errors) {
            //     errorMessages.add(error.getDefaultMessage()); 
            // }

            // model.addAttribute("errorMessages", errorMessages ); 
            model.addAttribute("movies", service.getMovies()); 
            model.addAttribute("movieForm", movieForm); 
            return "index"; 
        }
        service.vote(movieForm.getVote(), movieForm.getEmail());
        return "redirect:/";
    }
    
    

    
}
