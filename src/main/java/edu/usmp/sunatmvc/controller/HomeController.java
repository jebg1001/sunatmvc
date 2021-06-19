package edu.usmp.sunatmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import edu.usmp.sunatmvc.model.User;
import edu.usmp.sunatmvc.model.Fact;

import edu.usmp.sunatmvc.service.GDHService;
import org.springframework.validation.BindingResult;

@Controller
public class HomeController {
    
    private final GDHService gdhService;
    private static final String HOME_INDEX ="home/index"; 

    public HomeController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @RequestMapping("/home")
    public String login(Model model) {
        model.addAttribute("factura", new Fact());
        return HOME_INDEX;
    }

    @PostMapping("/login/crear")
    public String createSubmitForm(Model model, 
        Fact objFact, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro factura");
        }else{
            gdhService.addValidFactura(objFact);
            model.addAttribute("factura", objFact);
            model.addAttribute("mensaje", "Se registro factura");
        }
        return HOME_INDEX;
    }
}
