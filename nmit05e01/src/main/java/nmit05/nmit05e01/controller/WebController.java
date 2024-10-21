package nmit05.nmit05e01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nmit05.nmit05e01.domain.Form;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class WebController {
    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("form", new Form()); 
        return "indexView";
    }
    

    @PostMapping("/form/submit")
    public String showProcessedForm(Form form, Model model) {
        model.addAttribute("form", form );         
        return "resultView";
    }
    
}
