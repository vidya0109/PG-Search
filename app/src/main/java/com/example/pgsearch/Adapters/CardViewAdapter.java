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
import com.example.pgsearch.pgInfoActivity;

import java.util.ArrayList;


public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    ArrayList <String> pgname , pgOwnername;
    Context context;
    String city="";

    public CardViewAdapter (Context context, ArrayList pgname , ArrayList pgOwnername,String city) {
        this.context = context;
        this.pgname = pgname;
        this.pgOwnername = pgOwnername;
        this.city = city;

    }
    public CardViewAdapter (Context context, ArrayList pgname , ArrayList pgOwnername) {
        this.context = context;
        this.pgname = pgname;
        this.pgOwnername = pgOwnername;

    }

    @NonNull
    @Override
    public CardViewAdapter .ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_search_act, parent, false);
        CardViewAdapter.ViewHolder viewHolder = new CardViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        if (city.equals("")){

            holder.textView.setText(pgname.get(position));
            holder.textView2.setText(pgOwnername.get(position));

        }

        if (city.equals(pgOwnername.get(position))) {
            holder.textView.setText(pgname.get(position));
            holder.textView2.setText(pgOwnername.get(position));
        }

        holder.pgImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, pgInfoActivity.class);
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {


        if (city.equals(""))
            return pgname.size();
        else
            return pgname.size()-3;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView textView , textView2;
       ImageView pgImage;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.pg_name);
            textView2 = view.findViewById(R.id.pg_owner_name);
            pgImage = view.findViewById(R.id.pg_img);
        }
    }

}
