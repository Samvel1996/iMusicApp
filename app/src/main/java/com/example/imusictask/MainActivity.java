package com.example.imusictask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imusictask.base.OnItemClickListener;
import com.example.imusictask.entity.BaseResponse;
import com.example.imusictask.fragments.DetailsFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {


    private BaseResponseAdapter baseResponseAdapter;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        baseResponseAdapter = new BaseResponseAdapter();
        baseResponseAdapter.setOnItemClickListener(this);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.search();

        MutableLiveData<List<BaseResponse>> liveData = mainViewModel.getBaseResponseMutableLiveData();
        liveData.observe(this, new Observer<List<BaseResponse>>() {
            @Override
            public void onChanged(List<BaseResponse> baseResponses) {
                List<BaseResponse> list = mainViewModel.getAllResultsFromDB().getValue();
                if (list != null && baseResponses.containsAll(list) && list.containsAll(baseResponses))
                    return;
                mainViewModel.insertOrders(baseResponses);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(baseResponseAdapter);
        mainViewModel.getAllResultsFromDB().observe(this, new Observer<List<BaseResponse>>() {
            @Override
            public void onChanged(List<BaseResponse> baseResponseList) {
                baseResponseAdapter.setBaseResponseList(baseResponseList);
            }
        });
    }

    @Override
    public void onItemClicked(int position) {
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, DetailsFragment.newInstance(baseResponseAdapter.getItem(position))).addToBackStack(null).commit();
    }
}
