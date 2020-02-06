package com.example.imusictask.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.imusictask.utils.ConnectivityUtils;

public abstract class BaseViewModel extends AndroidViewModel {

    private Application application;


    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public boolean isConnected() {
        return ConnectivityUtils.isConnected(application);
    }
}
