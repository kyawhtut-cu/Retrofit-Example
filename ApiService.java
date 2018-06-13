package com.kyawhtut.athonesayin.util.network.api;

import com.kyawhtut.athonesayin.util.network.response.CategoryResponseList;
import com.kyawhtut.athonesayin.util.network.response.ServerResponseList;
import com.kyawhtut.athonesayin.util.network.response.StringResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by KyawHtut on 4/8/2018.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("/atonesayin/v1.api/getusage")
    Call<ServerResponseList> getUsageDataFromServer(
            @Field("user_id") String user_id,
            @Field("api_key") String api_key
    );

    @FormUrlEncoded
    @POST("/atonesayin/v1.api/insertUser")
    Call<StringResponse> insertUser(
            @Field("user_name") String user_name,
            @Field("user_id") String user_id,
            @Field("api_key") String api_key,
            @Field("user_profile") String user_profile,
            @Field("user_email") String user_email,
            @Field("login_status") int login_status,
            @Field("user_address") String user_address
    );

    @FormUrlEncoded
    @POST("/atonesayin/v1.api/getcategory")
    Call<CategoryResponseList> getCategoryFromServer(
            @Field("user_id") String user_id,
            @Field("api_key") String api_key
    );

    //Adv Api
    @FormUrlEncoded
    @POST("/atonesayin/v1.api/uploadusage")
    Call<StringResponse> uploadUsageDataToServer(
            @Field("api_key") String api_key,
            @Field("user_id") String user_id,
            @Field("usage_id") int usage_id,
            @Field("usage_note") String usage_note,
            @Field("usage_amount") long usage_amount,
            @Field("usage_time") long usage_time,
            @Field("time_short") String time_short,
            @Field("created_time") long created_time,
            @Field("updated_time") long updated_time,
            @Field("usage_status") int usage_status,
            @Field("server_status") int server_status,
            @Field("category_id") int category_id
    );

    @FormUrlEncoded
    @POST("/atonesayin/v1.api/uploadcategory")
    Call<StringResponse> uploadCategoryToServer(
            @Field("api_key") String api_key,
            @Field("user_id") String user_id,
            @Field("category_id") int category_id,
            @Field("category_name") String category_name,
            @Field("category_icon") String category_icon,
            @Field("server_status") int server_status
    );
}
