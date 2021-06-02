package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.pgsearch.Adapters.facilitiesInfoPageAdapter;
import com.example.pgsearch.Adapters.imageGalleryAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class pgInfoActivity extends AppCompatActivity {

    ImageView imagePgBg,imagePgProfile;
    RecyclerView facilitiesRecView,imageGalStaggeredRecView;

    ArrayList facilities = new ArrayList<>(Arrays.asList(R.drawable.airconditioner,R.drawable.reading,R.drawable.wifi,R.drawable.food));
    ArrayList pgImages = new ArrayList<>(Arrays.asList(R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4,R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_info);

        imagePgBg = findViewById(R.id.pg_info_bg_image);
        imagePgProfile = findViewById(R.id.pg_info_profile_img);
        facilitiesRecView = findViewById(R.id.facilities_grid_layout);
        imageGalStaggeredRecView = findViewById(R.id.pg_image_staggered);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),5);
        facilitiesRecView.setLayoutManager(gridLayoutManager);
        facilitiesInfoPageAdapter facilitiesInfoPageAdapter = new facilitiesInfoPageAdapter(pgInfoActivity.this,facilities);
        facilitiesRecView.setAdapter(facilitiesInfoPageAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        imageGalStaggeredRecView.setLayoutManager(staggeredGridLayoutManager);
        imageGalleryAdapter imageGalleryAdapter = new imageGalleryAdapter(pgInfoActivity.this,pgImages);
        imageGalStaggeredRecView.setAdapter(imageGalleryAdapter);

    }
}