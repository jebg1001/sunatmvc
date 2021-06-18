package edu.usmp.sunatmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import edu.usmp.sunatmvc.service.GDHService;
import edu.usmp.sunatmvc.dto.Factura;

@Controller
public class DashboardController {

    private final GDHService service;
    private static final String DASHBOARD_INDEX="dashboard";

    public DashboardController(GDHService service) {
        this.service = service;
    } 

    @GetMapping("dashboard")
    public String index(Model model) {
        List<Factura> facturas = service.getValidFacturas();
        int count=0;
        BigDecimal monto=new java.math.BigDecimal("0.00");;
        ZonedDateTime fecha=ZonedDateTime.now();
        for (Factura factura : facturas) {
            count++;
            monto=monto.add(factura.getMontoFactura());
            fecha=factura.getDate();
        }

        model.addAttribute("numClientes",count);
        model.addAttribute("cantEmisores",count);
        model.addAttribute("cantContrib",count);
        model.addAttribute("cantDinero",monto);
        model.addAttribute("fecha",fecha);
        return DASHBOARD_INDEX;
    }
}
