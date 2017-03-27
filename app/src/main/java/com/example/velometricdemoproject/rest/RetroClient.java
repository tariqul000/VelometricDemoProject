package com.example.velometricdemoproject.rest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author Tariqul
 */
public class RetroClient {
    public static final String BASE_URL = "http://aamargaan.com/";
    /********
     * URLS
     *******/
    //  private static final String ROOT_URL = "http://pratikbutani.x10.mx"

    //http://192.168.0.106/idrf/website/gallery_json
    //private static final String ROOT_URL = "http://aamargaan.com";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
