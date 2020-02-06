package com.example.imusictask.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.imusictask.entity.BaseResponse;

import java.util.List;

@Dao
public interface BaseResponseDao {
    @Insert()
    void insert(BaseResponse baseResponse);

    @Insert()
    void insertOrders(List<BaseResponse> order);

    @Delete
    void delete(BaseResponse baseResponse);


    @Query("DELETE FROM baseresponses")
    void deleteAll();

    @Query("SELECT * FROM baseresponses")
    LiveData<List<BaseResponse>> getAllItems();
}
