package edu.usmp.sunatmvc.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import edu.usmp.sunatmvc.dto.Factura;
import edu.usmp.sunatmvc.model.Fact;
import edu.usmp.sunatmvc.integration.api.SUNATAPI;

@Service
public class GDHService {

    private SUNATAPI sunatAPI;

    public GDHService(SUNATAPI sunatAPI){
        this.sunatAPI = sunatAPI;
    }
    
    public List<Factura> getValidFacturas(){
        List<Factura> facturasValid = sunatAPI.getFacturas().stream().
        collect(Collectors.toList());
        return facturasValid;
    }

    public void addValidFactura(Fact f){
        sunatAPI.postFactura(f);
    }
}
