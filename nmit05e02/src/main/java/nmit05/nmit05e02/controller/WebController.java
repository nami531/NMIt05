package nmit05.nmit05e02.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import nmit05.nmit05e02.domain.Dates;
import nmit05.nmit05e02.service.DateService;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;



@Controller
public class WebController {

    @Autowired
    private DateService s; 

    private String txtError=null; 

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("form", new Dates()); 
        if (txtError!=null){
            txtError=null; 
        }
        return "indexView";
    }
    
    @PostMapping("/form/submit")
    public String showResult(@Valid Dates form, 
                            BindingResult bindingResult, 
                            Model model) {
        model.addAttribute("form", form);
        try {
            if (form.getAction()==1){
                long result = s.difference(form.getDateOne(), form.getDateTwo());
                model.addAttribute("resultD", result); 
            } else if (form.getAction()==2) {
                ArrayList<Integer> result = s.leapYears(form.getDateOne(), form.getDateTwo()); 
                model.addAttribute("resultL", result); 

            } else {
                int result = s.january(form.getDateOne(), form.getDateTwo()); 
                model.addAttribute("resultS", result); 
            }
        } catch (Exception e) {
            txtError = e.getMessage(); 
            model.addAttribute("error", txtError); 
        }

        return "indexView";
    }
    
}
