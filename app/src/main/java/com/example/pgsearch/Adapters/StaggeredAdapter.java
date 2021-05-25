package com.example.pgsearch.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pgsearch.R;
import com.example.pgsearch.SearchActivty;

import java.util.ArrayList;

import static com.example.pgsearch.MainActivity.visStatus;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter .ViewHolder> {
    ArrayList images;
    Context context;


    public StaggeredAdapter (Context context, ArrayList images) {
        this.context = context;
        this.images = images;

    }

    @NonNull
    @Override
    public StaggeredAdapter .ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        StaggeredAdapter.ViewHolder viewHolder = new StaggeredAdapter .ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull StaggeredAdapter .ViewHolder holder, int position) {
        int res = (int) images.get(position);
        holder.images.setImageResource(res);
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visStatus = 1;
                Intent intent = new Intent(v.getContext(),SearchActivty.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return images.size();
    }

    // Initializing the Views
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView cityName;
        View v;


        public ViewHolder(View view) {
            super(view);
            images = (ImageView) view.findViewById(R.id.imageView);
            cityName = (TextView)view.findViewById(R.id.city_name);
            v = view;

        }
    }
}
