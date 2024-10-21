package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.model.FormIndex;
import com.example.app.model.FormInfo;


@Controller
@Scope("session")
public class MasterMindController {

    @Autowired
    public MasterMindService masterMindService;
    private String err; 

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("formIndex", new FormIndex()); 
        return "indexView";
    }

    @GetMapping("/juego")
    public String showGame(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        model.addAttribute("listaIntentos", masterMindService.masterMind.getListaIntentos());
        model.addAttribute("estadoJuego", masterMindService.masterMind.getEstadoJuego());
        model.addAttribute("err", err);
        return "juegoView";
    }

    @PostMapping("/juego")
    public String newTry(FormInfo formInfo, Model model) {
        try {
            err = null; 
            masterMindService.comprobarIntento(formInfo.getIntento());
        } catch (NumberFormatException e){
            this.err = e.getMessage(); 
            model.addAttribute("err", err); 
        } catch (RuntimeException e) {
            this.err = e.getMessage(); 
            model.addAttribute("err", err); 
        } 
        return "redirect:/juego";

    }

    @PostMapping("/nuevoJuego")
    public String proccesInfo(FormIndex formIndex, Model model) {
        masterMindService.nuevoJuego(formIndex.getLengthNum(), formIndex.getMaxTries());                 
        return "redirect:/juego";
    }
    
}
