package com.example.imusictask.network.retrofit;


import com.example.imusictask.entity.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestApiService {
    @GET("demos/marvel/")
    Call<List<BaseResponse>> search();
}
