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

public class imageGalleryAdapter extends RecyclerView.Adapter<imageGalleryAdapter. ViewHolder> {

    Context context;
    ArrayList images;

    public imageGalleryAdapter(Context context, ArrayList images){
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public imageGalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_gallery_item, parent, false);
        imageGalleryAdapter.ViewHolder viewHolder = new imageGalleryAdapter .ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull imageGalleryAdapter.ViewHolder holder, int position) {
        int res = (int) images.get(position);
        holder.image.setImageResource(res);
    }


    @Override
    public int getItemCount () {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        View v;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_gal_pg_img);
            v = itemView;

        }
    }

}

