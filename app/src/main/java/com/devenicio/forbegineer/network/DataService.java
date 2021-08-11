package com.devenicio.forbegineer.network;

import com.devenicio.forbegineer.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface DataService {

    @GET("{cep}/json/")
    Call<CEP>  getCep(@Path("cep")String cep) ;



}
