package com.example.pgsearch.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgsearch.R;

import java.util.ArrayList;

public class SearchActHorizontalAdapter extends RecyclerView.Adapter<SearchActHorizontalAdapter.ViewHolder> {
    ArrayList horizonTalImgList;
    Context context;

    public SearchActHorizontalAdapter(ArrayList horizonTalImgList, Context context) {
        this.horizonTalImgList = horizonTalImgList;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchActHorizontalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.horizontal_rec_view_cardview, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull SearchActHorizontalAdapter.ViewHolder holder, int position) {
        int res = (int) horizonTalImgList.get(position);
        holder.horizontalImage.setImageResource(res);
    }

    @Override
    public int getItemCount() {
        return horizonTalImgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView horizontalImage;
        View v;
        CardView horizontalRecViewCardView;

        public ViewHolder(View view) {
            super(view);
            horizontalImage = (ImageView) view.findViewById(R.id.horizontal_card_view_img);
            horizontalRecViewCardView = view.findViewById(R.id.cardViewHorizontalRecView);
            v = view;
        }
    }
}
