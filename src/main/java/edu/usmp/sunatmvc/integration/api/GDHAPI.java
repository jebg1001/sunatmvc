package edu.usmp.sunatmvc.integration.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.usmp.sunatmvc.model.Factura;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GDHAPI {
    
    @Value("${appexternal.endpoint.get.facturas}")
    private String URL_GET_FACTURAS;

    @Value("${appexternal.endpoint.post.facturas}")
    private String URL_POST_FACTURAS;

    private RestTemplate restTemplate;

    public GDHAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Factura> getFacturas(){
        ResponseEntity<List<Factura>> response = restTemplate.
                                    exchange(URL_GET_FACTURAS,
                                    HttpMethod.GET,
                                    HttpEntity.EMPTY,
                                    new ParameterizedTypeReference<List<Factura>>(){});
        return response.getBody();
    }

    public void postFacturas(Factura f){
        HttpEntity<Factura> bodyRequest = new  HttpEntity<Factura>(f);
        ResponseEntity<String> response = 
            restTemplate.exchange(URL_POST_FACTURAS,
                    HttpMethod.POST,
                    bodyRequest,
                    new ParameterizedTypeReference<String>(){}
            );
    }
}
