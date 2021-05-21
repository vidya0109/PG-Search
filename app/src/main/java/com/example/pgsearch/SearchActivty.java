package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pgsearch.Adapters.CardViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivty extends AppCompatActivity {

    RecyclerView recyclerView;
    CardViewAdapter cardViewAdapter;
    ArrayList <String> pgname , pgOwnername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activty);

        pgname = new ArrayList<>(Arrays.asList("Sample1" , "Sample2" , "Sample3" , "Sample4"));
        pgOwnername = new ArrayList<String>(Arrays.asList("Sample12" , "Sample23" , "Sample34" , "Sample45"));
        recyclerView = findViewById(R.id.recyclerViewCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardViewAdapter = new CardViewAdapter(this,pgname,pgOwnername);
        recyclerView.setAdapter(cardViewAdapter);



    }
}