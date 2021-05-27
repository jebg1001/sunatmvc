package edu.usmp.sunatmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.sunatmvc.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer>{
    
}
