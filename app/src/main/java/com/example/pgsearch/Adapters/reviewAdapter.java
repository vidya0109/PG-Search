package com.example.pgsearch.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgsearch.R;

public class reviewAdapter extends RecyclerView.Adapter<reviewAdapter. ViewHolder>{

    Context context;

    public reviewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public reviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_cardview, parent, false);
        reviewAdapter.ViewHolder viewHolder = new reviewAdapter .ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull reviewAdapter.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView reviewUserName, review;
        View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            review = itemView.findViewById(R.id.review);
            reviewUserName = itemView.findViewById(R.id.review_user_name);
            v = itemView;

        }
    }
}
