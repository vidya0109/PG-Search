package com.example.pgsearch.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgsearch.R;

import java.util.ArrayList;

public class facilitiesInfoPageAdapter extends RecyclerView.Adapter<facilitiesInfoPageAdapter .ViewHolder>{

    ArrayList facilities;
    Context context;

    public facilitiesInfoPageAdapter (Context context, ArrayList facilities) {
        this.context = context;
        this.facilities = facilities;

    }

    @NonNull
    @Override
    public facilitiesInfoPageAdapter .ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facility_card_view, parent, false);
        facilitiesInfoPageAdapter.ViewHolder viewHolder = new facilitiesInfoPageAdapter .ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull facilitiesInfoPageAdapter.ViewHolder holder, int position) {

        int res = (int) facilities.get(position);
        holder.imageFacility.setImageResource(res);

    }


    @Override
    public int getItemCount() {
        return facilities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageFacility;
        View v;

        public ViewHolder( View itemView) {
            super(itemView);
            imageFacility = itemView.findViewById(R.id.facilities_card_view_img);
            v = itemView;
        }
    }
}
