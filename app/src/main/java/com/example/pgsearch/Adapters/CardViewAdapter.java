package com.example.pgsearch.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pgsearch.R;
import java.util.ArrayList;


public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    ArrayList <String> pgname , pgOwnername;
    Context context;
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

        int i = position;
        holder.textView.setText(pgname.get(i));
        holder.textView2.setText(pgOwnername.get(i));



    }



    @Override
    public int getItemCount() {

        return pgname.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView textView , textView2;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.pg_name);
            textView2 = view.findViewById(R.id.pg_owner_name);
        }
    }

}
