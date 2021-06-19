package edu.usmp.sunatmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import edu.usmp.sunatmvc.dto.Factura;
import edu.usmp.sunatmvc.model.Fact;
import edu.usmp.sunatmvc.service.GDHService;
import org.springframework.validation.BindingResult;


@Controller
public class FacturaController {
    
    private final GDHService gdhService;
    private static final String FACTURA_INDEX = "factura";
    private static final String CREAR_INDEX = "factura/crear";

    public FacturaController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @GetMapping("/factura")
    public String index(Model model) {
        List<Factura> facturas = gdhService.getValidFacturas();
        model.addAttribute("facturas", facturas);
        return FACTURA_INDEX;
    }

    @GetMapping("/factura/crear")
    public String crear(Model model) {
        model.addAttribute("factura", new Fact());
        return CREAR_INDEX;
    }

    @PostMapping("/factura/crear")
    public String createSubmitForm(Model model, 
        Fact objFact, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro factura");
        }else{
            gdhService.addValidFactura(objFact);
            model.addAttribute("factura", objFact);
            model.addAttribute("mensaje", "Se registro factura");
        }
        return CREAR_INDEX;
    }

    
}
