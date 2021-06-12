package edu.usmp.sunatmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import edu.usmp.sunatmvc.dto.Factura;
import edu.usmp.sunatmvc.service.GDHService;


@Controller
public class DashboardController {
    
    private final GDHService gdhService;
    private static final String DASHBOARD_INDEX = "dashboard/index";

    public DashboardController(GDHService gdhService) {
        this.gdhService = gdhService;
    }

    @GetMapping("/dashboard")
    public String index(Model model) {
        model.addAttribute("dashboard", new Factura());
        return DASHBOARD_INDEX;
    }

}

