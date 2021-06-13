package edu.usmp.sunatmvc.repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.usmp.sunatmvc.model.Fact;

@Repository
public interface FacturaRepository extends JpaRepository<Fact,String>{
    
    @Query("SELECT p.rucContribuyente as rucContribuyente,SUM(p.montoFactura) as montoFactura FROM Fact p GROUP BY p.rucContribuyente")
    List<Map<String, Object>> queryByrucContribuyente();


}
