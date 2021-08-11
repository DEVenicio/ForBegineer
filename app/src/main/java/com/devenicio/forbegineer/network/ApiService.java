package com.devenicio.forbegineer.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static DataService INSTANCE;

    public static DataService getInstance() {
        if (INSTANCE == null) {

          Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://viacep.com.br/ws/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

           INSTANCE = retrofit.create(DataService.class);
        }
        return INSTANCE;
    }
}
