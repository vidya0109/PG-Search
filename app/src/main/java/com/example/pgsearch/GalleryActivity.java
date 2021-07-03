package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.pgsearch.Adapters.imageGalleryAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class GalleryActivity extends AppCompatActivity {

    ArrayList pgImages = new ArrayList<>(Arrays.asList(R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4,R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4));
    RecyclerView imageGalStaggeredRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        imageGalStaggeredRecView = findViewById(R.id.pg_image_staggered);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        imageGalStaggeredRecView.setLayoutManager(staggeredGridLayoutManager);
        imageGalleryAdapter imageGalleryAdapter = new imageGalleryAdapter(GalleryActivity.this,pgImages);
        imageGalStaggeredRecView.setAdapter(imageGalleryAdapter);
    }
}