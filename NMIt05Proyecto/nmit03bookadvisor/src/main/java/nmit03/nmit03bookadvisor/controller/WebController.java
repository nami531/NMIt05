package nmit03.nmit03bookadvisor.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import nmit03.nmit03bookadvisor.domain.Form;
import nmit03.nmit03bookadvisor.service.EmailService;



@Controller
public class WebController {
    @Autowired
    private EmailService emailService;  

    @GetMapping({" ", "/", "/index"})
    public String showIndex(Model model){
        model.addAttribute("year", LocalDate.now().getYear()); 
        return "index"; 
    }

    @GetMapping("/about")
    public String showAbout(){
        return "about"; 
    }

    @GetMapping("/contact")
    public String getMethodName(Model model) {
        model.addAttribute("form", new Form()); 
        return "contact";
    }
    

    @PostMapping("/form/submit")
    public String postMethodName(Form form, Model model) {
        model.addAttribute("form", form); 
        String cuerpoMensaje = form.toString();
        String destinatario= form.getEmail(); 
        String asunto = "Project";
        emailService.sendEmail(destinatario,asunto,cuerpoMensaje);
        return "redirect:/contact"; 
    }
    
}
