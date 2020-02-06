package com.example.imusictask.network.retrofit;

import androidx.lifecycle.MutableLiveData;

import com.example.imusictask.entity.BaseResponse;

import java.util.List;


public class RetrofitRepository implements RequestManager.OnSearchListener {
    private MutableLiveData<List<BaseResponse>> allRetrofitResponse;

  public  RetrofitRepository(){
        allRetrofitResponse = new MutableLiveData<>();
    }

    public void search(){
      RequestManager.search(this);
    }



    @Override
    public void onSearchSuccess(List<BaseResponse> baseResponse) {
        allRetrofitResponse.setValue(baseResponse);
    }

    @Override
    public void onSearchFail(String failureMsg) {
      allRetrofitResponse.setValue(null);

    }

    public MutableLiveData<List<BaseResponse>>getAllRetrofitResponse() {
        return allRetrofitResponse;
    }
}
