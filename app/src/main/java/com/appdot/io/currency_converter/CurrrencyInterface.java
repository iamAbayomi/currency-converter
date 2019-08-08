package com.appdot.io.currency_converter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrrencyInterface {

    @GET("api/latest?access_key=30ce77bd4d56997198e4186a3785f8ea&symbols=USD,AUD,CAD,PLN,MXN&format=1")
    Call<CurrencyModel> getCurrency();

}
