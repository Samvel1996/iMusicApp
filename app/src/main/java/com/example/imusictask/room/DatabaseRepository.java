package com.example.imusictask.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.imusictask.entity.BaseResponse;

import java.util.List;

public class DatabaseRepository {
    private BaseResponseDao baseResponseDao;
    private LiveData<List<BaseResponse>> listLiveData;

    public DatabaseRepository(Application application) {
        baseResponseDao = BaseResponseDatabase.getInstance(application).baseResponseDao();
        listLiveData = baseResponseDao.getAllItems();
    }
    public void insert(BaseResponse baseResponse) {
        new InsertAsyncTask(baseResponseDao).execute(baseResponse);

    }

    public void insertOrders(List<BaseResponse> baseResponseList) {
        new InsertOrdersAsyncTask(baseResponseDao).execute(baseResponseList);
    }

    public void delete(BaseResponse baseResponse) {
        new DeleteAsyncTask(baseResponseDao).execute(baseResponse);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask(baseResponseDao).execute();
    }

    public LiveData<List<BaseResponse>> getAllResults() {
        new GetAllItemsAsyncTask(baseResponseDao).execute();
        return listLiveData;
    }


    static class GetAllItemsAsyncTask extends AsyncTask<Void, Void, Void> {
        private BaseResponseDao baseResponseDao;

        GetAllItemsAsyncTask(BaseResponseDao baseResponseDao) {
            this.baseResponseDao = baseResponseDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            baseResponseDao.getAllItems();
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private BaseResponseDao baseResponseDao;

        DeleteAllAsyncTask(BaseResponseDao baseResponseDao) {
            this.baseResponseDao = baseResponseDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            baseResponseDao.deleteAll();
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<BaseResponse, Void, Void> {
        private BaseResponseDao baseResponseDao;

        DeleteAsyncTask(BaseResponseDao baseResponseDao) {
            this.baseResponseDao = baseResponseDao;
        }

        @Override
        protected Void doInBackground(BaseResponse... baseResponses) {
            baseResponseDao.delete(baseResponses[0]);
            return null;
        }
    }


    static class InsertOrdersAsyncTask extends AsyncTask<List<BaseResponse>, Void, Void> {
        private BaseResponseDao baseResponseDao;

        InsertOrdersAsyncTask(BaseResponseDao baseResponseDao) {
            this.baseResponseDao = baseResponseDao;
        }

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<BaseResponse>... lists) {
            baseResponseDao.insertOrders(lists[0]);
            return null;
        }
    }

    static class InsertAsyncTask extends AsyncTask<BaseResponse, Void, Void> {
        private BaseResponseDao baseResponseDao;

        InsertAsyncTask(BaseResponseDao baseResponseDao) {
            this.baseResponseDao = baseResponseDao;
        }

        @Override
        protected Void doInBackground(BaseResponse... baseResponses) {
            baseResponseDao.insert(baseResponses[0]);
            return null;
        }
    }
}
