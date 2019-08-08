package com.appdot.io.currency_converter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final  String BASE_URL = "http://data.fixer.io/";

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){

            retrofit = new  retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        }
}
