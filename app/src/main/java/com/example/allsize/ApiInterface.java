package com.example.allsize;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("goods/?format=json")
//    Call<ArrayList<Good>> getGoodsList();
    Call<GoodResponse> getGoodsList();

    @GET("colors/?format=json")
    Call<ColorResponse> getColorsList();

}
