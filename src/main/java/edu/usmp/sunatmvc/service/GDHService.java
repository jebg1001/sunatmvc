package edu.usmp.sunatmvc.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.usmp.sunatmvc.domain.Factura;
import edu.usmp.sunatmvc.integration.api.GDHAPI;
import edu.usmp.sunatmvc.integration.api.SUNATAPI;

@Service
public class GDHService {

    private SUNATAPI sunatAPI;

    public GDHService(SUNATAPI sunatAPI){
        this.sunatAPI = sunatAPI;
    }

    public void realizarPago(Map datosPago){

        //TODO crear Pedidos
        
        //TODO call api post pago

        //TODO: call api post sunat
        sunatAPI.sendFactura(null);
        //TODO: Call api post delivery

    }
}
