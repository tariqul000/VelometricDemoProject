package com.example.velometricdemoproject.rest;


import com.example.velometricdemoproject.holder.AllHomeViewHolder;
import com.example.velometricdemoproject.model.HomeViewModel;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * @author Tariqul
 */
public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
  /*  @GET("/datafeed.json.php?section=top10")
    Call<List<AllHomeViewHolder>> getMyJSON();*/
    @GET
    Call<List<HomeViewModel>> getMyJSON(@Url String url);


}


