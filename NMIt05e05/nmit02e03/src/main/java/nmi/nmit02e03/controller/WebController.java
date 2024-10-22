package nmi.nmit02e03.controller;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import nmi.nmit02e03.domain.FormInfo;
import nmi.nmit02e03.service.EmailService;
import nmi.nmit02e03.service.FileStorageService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private FileStorageService fileStorageService;

    private HashMap<String, String[]> achievements = new HashMap<>();

    @GetMapping({ "/index", " ", "/", "/home" })
    public String showIndex(Model model) {
        model.addAttribute("year", LocalDate.now().getYear());
        return "indexView";
    }

    @GetMapping("/{user}")
    public String showNameUse(Model model, @PathVariable String user) {
        model.addAttribute("year", LocalDate.now().getYear());
        model.addAttribute("user", user);
        return "indexView";
    }

    @GetMapping("/team")
    public String showTeam(Model model) {
        achievements.put("Copa del Rey Runners-up", new String[] { "1947–48 (lost against Sevilla)",
                "1993–94 (lost against Real Zaragoza)", "2000–01 (lost against Real Zaragoza)" });
        achievements.put("Participation in UEFA Champions League",
                new String[] { "2003–04 (eliminated in Round of 16 by Arsenal)" });
        achievements.put("Qualifications in UEFA Europa League",
                new String[] { "1998–99 (Quarter-finals)", "1999–2000 (Round of 16)", "2000–01 (Quarter-finals)",
                        "2006–07 (Round of 32)", "2016–17 (Semi-finals, eliminated by Manchester United)" });
        achievements.put("Champion of the Spanish Second Division", new String[] { "1935–36", "1980–81", "1991–92" });
        model.addAttribute("achievements", achievements);
        return "teamView";
    }

    @GetMapping("/photos-gallery")
    public String showGallery() {
        return "photos-galleryView";
    }

    @GetMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "contactView";
    }

    @PostMapping("/submit/form")
    public String proccessInfo(FormInfo formInfo, @RequestParam MultipartFile file, Model model) {
        model.addAttribute("formInfo", formInfo);
        boolean dataProcessed = true;
        model.addAttribute("dataProcessed", dataProcessed);

        String newFileName = fileStorageService.store(file);

        String cuerpoMensaje = formInfo.toString();
        String destinatario= formInfo.getEmail(); 
        String asunto = "Exercise 5.5";
        emailService.sendEmail(destinatario,asunto,cuerpoMensaje, newFileName);
        return "redirect:/contact";
    }

}
