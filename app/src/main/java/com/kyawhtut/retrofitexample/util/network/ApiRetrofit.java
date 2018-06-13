package com.kyawhtut.retrofitexample.util.network;

import android.util.Log;

import com.kyawhtut.retrofitexample.BuildConfig;
import com.kyawhtut.retrofitexample.util.data.MemeResponse;
import com.kyawhtut.retrofitexample.util.network.eventbus.MemeEvent;
import com.kyawhtut.retrofitexample.util.network.service.ApiService;
import com.kyawhtut.retrofitexample.util.network.service.DataAgent;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit implements DataAgent {

    public static ApiRetrofit INSTANCE;
    private ApiService mService;

    private ApiRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        mService = mRetrofit.create(ApiService.class);
    }

    public static ApiRetrofit getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ApiRetrofit();
        }
        return INSTANCE;
    }

    @Override
    public void getAllData() {
        Call<MemeResponse> call = mService.getAllData();
        call.enqueue(new Callback<MemeResponse>() {
            @Override
            public void onResponse(Call<MemeResponse> call, Response<MemeResponse> response) {
                if (response.isSuccessful()) {
                    EventBus.getDefault().post(new MemeEvent("success", response.body()));
                } else {
                    EventBus.getDefault().post(new MemeEvent("error"));
                }
            }

            @Override
            public void onFailure(Call<MemeResponse> call, Throwable t) {
                EventBus.getDefault().post(new MemeEvent("error"));
            }
        });
    }

    @Override
    public void getDataWithPage(int page) {
        Call<MemeResponse> call = mService.getDataWithPage(page);
        call.enqueue(new Callback<MemeResponse>() {
            @Override
            public void onResponse(Call<MemeResponse> call, Response<MemeResponse> response) {
                if (response.isSuccessful()) {
                    EventBus.getDefault().post(new MemeEvent("success", response.body()));
                } else {
                    EventBus.getDefault().post(new MemeEvent("error"));
                }
            }

            @Override
            public void onFailure(Call<MemeResponse> call, Throwable t) {
                EventBus.getDefault().post(new MemeEvent("error"));
            }
        });
    }

    @Override
    public void getDataWithPageAndQuery(int page, String query) {
        Call<MemeResponse> call = mService.getDataWithPageAndQuery(page, query);
        call.enqueue(new Callback<MemeResponse>() {
            @Override
            public void onResponse(Call<MemeResponse> call, Response<MemeResponse> response) {
                if (response.isSuccessful()) {
                    EventBus.getDefault().post(new MemeEvent("success", response.body()));
                } else {
                    EventBus.getDefault().post(new MemeEvent("error"));
                }
            }

            @Override
            public void onFailure(Call<MemeResponse> call, Throwable t) {
                EventBus.getDefault().post(new MemeEvent("error"));
            }
        });
    }
}
