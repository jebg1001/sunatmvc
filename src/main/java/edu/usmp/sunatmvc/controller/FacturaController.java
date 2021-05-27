package edu.usmp.sunatmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import edu.usmp.sunatmvc.dto.Factura;
import edu.usmp.sunatmvc.service.GDHService;


@Controller
public class FacturaController {
    
    private final GDHService gdhService;
    private static final String FACTURA_INDEX = "factura/index";

    public FacturaController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @GetMapping("/factura")
    public String index(Model model) {
        List<Factura> facturas = gdhService.getValidFacturas();
        model.addAttribute("facturas", facturas);
        return FACTURA_INDEX;
    }

}
