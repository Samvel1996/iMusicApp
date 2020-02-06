package com.example.imusictask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.imusictask.base.BaseViewModel;
import com.example.imusictask.entity.BaseResponse;
import com.example.imusictask.network.retrofit.RetrofitRepository;
import com.example.imusictask.room.DatabaseRepository;

import java.util.List;

public class MainViewModel extends BaseViewModel {
    private RetrofitRepository retrofitRepository;
    private MutableLiveData<List<BaseResponse>> baseResponseMutableLiveData;
    private DatabaseRepository databaseRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        retrofitRepository = new RetrofitRepository();
        baseResponseMutableLiveData = retrofitRepository.getAllRetrofitResponse();
        databaseRepository = new DatabaseRepository(application);
    }

    public MutableLiveData<List<BaseResponse>> getBaseResponseMutableLiveData() {
        return baseResponseMutableLiveData;
    }

    public void search() {
        if (isConnected())
            retrofitRepository.search();
    }


    public void insert(BaseResponse baseResponse) {
        databaseRepository.insert(baseResponse);
    }


    public void insertOrders(List<BaseResponse> baseResponseList) {
        databaseRepository.insertOrders(baseResponseList);
    }

    public void delete(BaseResponse baseResponse) {
        databaseRepository.delete(baseResponse);
    }

    public void deleteAll() {
        databaseRepository.deleteAll();
    }

    public LiveData<List<BaseResponse>> getAllResultsFromDB() {
        return databaseRepository.getAllResults();
    }
}

