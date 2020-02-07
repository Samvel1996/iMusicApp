package com.example.imusictask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imusictask.base.OnItemClickListener;
import com.example.imusictask.entity.BaseResponse;
import com.example.imusictask.utils.utils_glide.GlideUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseResponseAdapter extends RecyclerView.Adapter<BaseResponseAdapter.MyViewHolder> {
    private List<BaseResponse> baseResponseList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private Context context;


    public void setBaseResponseList(List<BaseResponse> baseResponseList) {
        this.baseResponseList = baseResponseList;
        notifyDataSetChanged();
    }

    public BaseResponse getItem(int position) {
        return baseResponseList.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<BaseResponse> getBaseResponseList() {
        return baseResponseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baseresponse, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BaseResponse currResponse = baseResponseList.get(position);
        holder.tvName.setText(currResponse.getName());
        holder.tvTeam.setText(currResponse.getTeam());
        GlideUtils.setFitCenterImage(holder.ivImage, currResponse.getImageurl());

    }

    @Override
    public int getItemCount() {
        return baseResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivImage;
        private TextView tvName;
        private TextView tvTeam;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTeam = itemView.findViewById(R.id.tv_team);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                onItemClickListener.onItemClicked(getAdapterPosition());
            }
        }
    }
}
