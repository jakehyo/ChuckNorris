package com.example.han.chucknorris;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by per6 on 1/29/18.
 */

public interface   ChuckNorrisAPI {
    String baseUrl = "https://api.chucknorris.io/jokes/";

    @GET("search?")
    Call<JokeList> getJokeList(@Query("query") String search);
    //it is Call so that we can receive
    //the data ASYNCHRONOUSLY so we don't
    //halt the UI Thread while it loads
}
