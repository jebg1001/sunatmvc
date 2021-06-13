package edu.usmp.sunatmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;
import edu.usmp.sunatmvc.repository.*;

@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DashboardController {
    private final FacturaRepository factData;

    public DashboardController(FacturaRepository factData){
        this.factData = factData;
    } 

    @GetMapping(value = "/facturas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> employees(){
        return  new ResponseEntity<List<Map<String, Object>>>(
            factData.queryByrucContribuyente(), HttpStatus.OK);
    }
}
