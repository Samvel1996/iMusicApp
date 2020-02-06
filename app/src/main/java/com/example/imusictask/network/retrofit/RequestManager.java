package com.example.imusictask.network.retrofit;

import com.example.imusictask.entity.BaseResponse;
import com.example.imusictask.utils.LogUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManager {
    public static void search(final OnSearchListener onSearchListener) {
        Call<List<BaseResponse>> call = RetrofitClient.getInstance().getRequestApiService().search();
        call.enqueue(new Callback<List<BaseResponse>>() {
            @Override
            public void onResponse(Call<List<BaseResponse>> call, Response<List<BaseResponse>> response) {
                LogUtils.d(this.getClass().getSimpleName() + "message: " + response.message());
                if (response.body() != null) {
                    onSearchListener.onSearchSuccess(response.body());
                    LogUtils.d("code: " + response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<List<BaseResponse>> call, Throwable t) {

                onSearchListener.onSearchFail(t.toString());
                LogUtils.d("onFailure: call" + call.toString());
                LogUtils.d("onFailure: throwable" + t.toString());
            }
        });
    }








    public interface OnSearchListener{
        void onSearchSuccess(List<BaseResponse> baseResponse);
        void onSearchFail(String failureMsg);
    }
}
