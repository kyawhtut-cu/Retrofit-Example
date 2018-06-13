package com.kyawhtut.retrofitexample.util.network.service;

import com.kyawhtut.retrofitexample.util.data.MemeResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by KyawHtut on 4/8/2018.
 */

public interface ApiService {

    @GET("/memes")
    Call<MemeResponse> getAllData();

    @POST("/memes/p")
    @FormUrlEncoded
    Call<MemeResponse> getDataWithPage(
            @Field("page") int page
    );

    @POST("/memes/p/q")
    @FormUrlEncoded
    Call<MemeResponse> getDataWithPageAndQuery(
            @Field("page") int page,
            @Field("query") String query
    );
}
