package edu.usmp.sunatmvc.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

import edu.usmp.sunatmvc.model.Factura;
import edu.usmp.sunatmvc.repository.FacturaRepository;

@RestController
@RequestMapping(value = "api/factura", produces = "application/json")
public class FacturaController {

    private FacturaRepository facturaRepository;

    public FacturaController(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Factura>> facturas() {
        return new ResponseEntity<List<Factura>>(
            facturaRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> facturas(@PathVariable int id){
        Optional<Factura> optionalEntity = facturaRepository.findById(id);
        if(optionalEntity.isPresent()){
            return new ResponseEntity<Factura>(optionalEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> create(@RequestBody Factura f){
        facturaRepository.save(f);
        facturaRepository.flush();
        return new ResponseEntity<Factura>(f,  HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> update (@RequestBody Factura f){
        create(f);
        return new ResponseEntity<Factura>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> delete(@PathVariable int id) {
        facturaRepository.deleteById(id);
        return new ResponseEntity<Factura>(HttpStatus.OK);
    }
    
}