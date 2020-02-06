package com.example.imusictask.network.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitClient {
    private static final String BASE_URL ="https://simplifiedcoding.net/";
    private static RetrofitClient thisInstance = null;
    private RequestApiService requestApiService;

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( BASE_URL )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        requestApiService = retrofit.create ( RequestApiService.class );
    }

    public RequestApiService getRequestApiService() {
        return requestApiService;
    }

    public static RetrofitClient getInstance(){
        if(thisInstance == null){
            synchronized (RetrofitClient.class) {
                thisInstance = new RetrofitClient();
            }
        }
        return thisInstance;
    }
}
