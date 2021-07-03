package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pgsearch.Adapters.SearchActHorizontalAdapter;
import com.example.pgsearch.Adapters.facilitiesInfoPageAdapter;
import com.example.pgsearch.Adapters.imageGalleryAdapter;
import com.example.pgsearch.Adapters.reviewAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class pgInfoActivity extends AppCompatActivity {

    ImageView imagePgBg,imagePgProfile,location,contact;
    RecyclerView facilitiesRecView,imageGalStaggeredRecView,reviewRecView;
    RelativeLayout galleryImage;
    TextView loadMoreReviews;

    ArrayList facilities = new ArrayList<>(Arrays.asList(R.drawable.airconditioner,R.drawable.reading,R.drawable.wifi,R.drawable.food));
    ArrayList pgImages = new ArrayList<>(Arrays.asList(R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4,R.drawable.home1,R.drawable.home2,R.drawable.home3,R.drawable.home4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            imagePgBg = findViewById(R.id.pg_info_bg_image);
            imagePgProfile = findViewById(R.id.pg_info_profile_img);
            facilitiesRecView = findViewById(R.id.facilities_grid_layout);
            imageGalStaggeredRecView = findViewById(R.id.pg_image_staggered);
            galleryImage = findViewById(R.id.gallery_image);
            loadMoreReviews = findViewById(R.id.load_reviews);
            location = findViewById(R.id.location);
            contact = findViewById(R.id.contact);

            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri navigationIntentUri = Uri.parse("google.navigation:q=" + 12f + "," + 2f);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigationIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            });

            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1234567891"));
                    startActivity(intent);

                }
            });
            galleryImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(pgInfoActivity.this, GalleryActivity.class);
                    startActivity(intent);
                }
            });

            loadMoreReviews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(pgInfoActivity.this, reviewsActivity.class);
                    startActivity(intent);
                }
            });

            reviewRecView = findViewById(R.id.review_rec_view);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 5);
            facilitiesRecView.setLayoutManager(gridLayoutManager);
            facilitiesInfoPageAdapter facilitiesInfoPageAdapter = new facilitiesInfoPageAdapter(pgInfoActivity.this, facilities);
            facilitiesRecView.setAdapter(facilitiesInfoPageAdapter);

            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
            imageGalStaggeredRecView.setLayoutManager(staggeredGridLayoutManager);
            imageGalleryAdapter imageGalleryAdapter = new imageGalleryAdapter(pgInfoActivity.this, pgImages);
            imageGalStaggeredRecView.setAdapter(imageGalleryAdapter);


            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            reviewRecView.setLayoutManager(linearLayoutManager);
            reviewAdapter searchActHorizontalAdapter = new reviewAdapter(pgInfoActivity.this);
            reviewRecView.setAdapter(searchActHorizontalAdapter);


        }
    }