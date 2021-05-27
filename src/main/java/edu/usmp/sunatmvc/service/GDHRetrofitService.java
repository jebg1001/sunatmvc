package edu.usmp.sunatmvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import edu.usmp.sunatmvc.domain.Factura;
//import edu.usmp.sunatmvc.integration.api.GDHAPIRetrofit;
//import retrofit2.Call;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class GDHRetrofitService {

    @Value("${appexternal.endpoint.get.facturas}")
    private String URL_ENPOINT;

    @Value("${appexternal.url}")
    private String URL_EXTERNAL;

    //private GDHAPIRetrofit gdhAPI;

    /*public GDHRetrofitService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://usmpsunat.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gdhAPI = retrofit.create(GDHAPIRetrofit.class);
    }
    
    public List<Factura> queryFacturaExternal(){
        Call<List<Factura>> retrofitCall = gdhAPI.getFacturas();
        Response<List<Factura>> response = null;
        try {
            response = retrofitCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }*/

}