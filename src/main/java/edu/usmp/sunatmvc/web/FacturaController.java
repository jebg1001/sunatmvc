package edu.usmp.sunatmvc.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import edu.usmp.sunatmvc.domain.Factura;
import edu.usmp.sunatmvc.repository.FacturaRepository;

@RestController
public class FacturaController {

    private FacturaRepository facturaRepository;

    public FacturaController(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }


    @GetMapping(value = "/facturas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Factura>> facturas() {
        return new ResponseEntity<List<Factura>>(
            facturaRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/factura/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> facturas(@PathVariable int id){
        Optional<Factura> optionalEntity = facturaRepository.findById(id);
        if(optionalEntity.isPresent()){
            return new ResponseEntity<Factura>(optionalEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/factura", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> create(@RequestBody Factura f){
        facturaRepository.save(f);
        facturaRepository.flush();
        return new ResponseEntity<Factura>(f,  HttpStatus.CREATED);
    }

    @PutMapping(value = "/factura", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> update (@RequestBody Factura f){
        create(f);
        return new ResponseEntity<Factura>(HttpStatus.OK);
    }
    
}