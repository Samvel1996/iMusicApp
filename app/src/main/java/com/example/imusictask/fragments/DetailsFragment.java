package com.example.imusictask.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.imusictask.R;
import com.example.imusictask.base.BaseFragment;
import com.example.imusictask.entity.BaseResponse;

public class DetailsFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivDetailsImage;
    private TextView tvName;
    private TextView tvRealName;
    private TextView tvFirsApperance;
    private TextView tvTeam;
    private TextView tvBio;

    private BaseResponse baseResponse;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(BaseResponse baseResponse) {
        DetailsFragment fragment = new DetailsFragment();
        fragment.baseResponse = baseResponse;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ivDetailsImage = view.findViewById(R.id.iv_details_image);
        tvName = view.findViewById(R.id.tv_name);
        tvRealName = view.findViewById(R.id.tv_real_name);
        tvFirsApperance = view.findViewById(R.id.tv_first_apperance);
        tvTeam = view.findViewById(R.id.tv_team);
        tvBio = view.findViewById(R.id.tv_bio);
        ImageView ivClose = view.findViewById(R.id.iv_close);
        ivClose.setOnClickListener(this);

        initValues();

        return view;
    }

    private void initValues() {
        if (baseResponse == null)
            return;
        tvName.setText(baseResponse.getName());
        tvRealName.setText(baseResponse.getRealname());
        tvFirsApperance.setText(baseResponse.getFirstappearance());
        tvTeam.setText(baseResponse.getTeam());
        tvBio.setText(baseResponse.getBio());
        Glide.with(this).load(baseResponse.getImageurl()).into(ivDetailsImage);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_close) {
            goBack();
        }
    }
}
