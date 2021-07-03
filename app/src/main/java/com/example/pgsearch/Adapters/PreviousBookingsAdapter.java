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
import androidx.viewpager.widget.PagerAdapter;

import com.example.pgsearch.JavaModels.PreviousBookingsInfo;
import com.example.pgsearch.PreviousBookings;
import com.example.pgsearch.R;

import java.util.ArrayList;

public class PreviousBookingsAdapter extends RecyclerView.Adapter<PreviousBookingsAdapter. ViewHolder>{

    Context context;
    ArrayList<PreviousBookingsInfo> p;
    public PreviousBookingsAdapter(Context context, ArrayList<PreviousBookingsInfo> p){
        this.context = context;
        this.p = p;
    }

    @NonNull
    @Override
    public PreviousBookingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_cardview, parent, false);
        PreviousBookingsAdapter.ViewHolder viewHolder = new PreviousBookingsAdapter .ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       holder.reviewUserName.setText(p.get(position).getName());
       holder.reviewUserName.setText(p.get(position).getPrevious());


    }




    @Override
    public int getItemCount() {
        return p.size();
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
