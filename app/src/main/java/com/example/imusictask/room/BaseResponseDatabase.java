package com.example.imusictask.room;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.imusictask.entity.BaseResponse;

@Database(entities = BaseResponse.class,version = 1,exportSchema = false)
public abstract class BaseResponseDatabase extends RoomDatabase {

    private static final String DB_NAME = "baseresponses";
    abstract BaseResponseDao baseResponseDao();



    private static BaseResponseDatabase instance;

    public static synchronized BaseResponseDatabase getInstance(Application application) {
        if (instance == null) {
          instance = Room.databaseBuilder(application,BaseResponseDatabase.class,DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }


}
