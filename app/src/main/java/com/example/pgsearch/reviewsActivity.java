package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pgsearch.Adapters.reviewAdapter;

public class reviewsActivity extends AppCompatActivity {

    RecyclerView reviewRecViewAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        reviewRecViewAct = findViewById(R.id.review_rec_view_rec_act);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        reviewRecViewAct.setLayoutManager(linearLayoutManager);
        reviewAdapter searchActHorizontalAdapter = new reviewAdapter(reviewsActivity.this);
        reviewRecViewAct.setAdapter(searchActHorizontalAdapter);

    }
}