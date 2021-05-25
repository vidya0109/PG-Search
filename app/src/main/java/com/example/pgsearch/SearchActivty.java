package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.pgsearch.Adapters.CardViewAdapter;
import com.example.pgsearch.Adapters.SearchActHorizontalAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import static com.example.pgsearch.MainActivity.visStatus;


public class SearchActivty extends AppCompatActivity {

    RecyclerView recyclerView;
    CardViewAdapter cardViewAdapter;
    ArrayList <String> pgname , pgOwnername;
    RelativeLayout citySelectedRel;
    ImageView citySelectCancelBTn;
    RecyclerView horizontalRecViewSearchAct;
    EditText search;
    ArrayList horizontalImg = new ArrayList(Arrays.asList(R.drawable.wifi,R.drawable.food,R.drawable.furnitures,R.drawable.airconditioner,
            R.drawable.reading,R.drawable.wifi,R.drawable.food,R.drawable.furnitures,R.drawable.airconditioner,
            R.drawable.reading));
    ImageView searcButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        citySelectCancelBTn = findViewById(R.id.city_select_cancel_btn);
        citySelectedRel = findViewById(R.id.search_act_city_select_rel);
        pgname = new ArrayList<>(Arrays.asList("Sample1" , "Sample2" , "Sample3" , "Sample4","Sample5","Sample6"));
        pgOwnername = new ArrayList<String>(Arrays.asList("Bangalore" , "Delhi" , "Mumbai" , "Srinagar","Bangalore","Srinagar"));
        horizontalRecViewSearchAct = findViewById(R.id.searchActHorizontalRecView);
        recyclerView = findViewById(R.id.recyclerViewCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        search  = findViewById(R.id.search_bar_search_act);
        searcButton = findViewById(R.id.mag_icon_search_act);
        cardViewAdapter = new CardViewAdapter(SearchActivty.this,pgname,pgOwnername);
        recyclerView.setAdapter(cardViewAdapter);



        searcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String city  = search.getText().toString();
                System.out.println(city);
                cardViewAdapter = new CardViewAdapter(SearchActivty.this,pgname,pgOwnername,city);
                recyclerView.setAdapter(cardViewAdapter);


            }
        });




        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        horizontalRecViewSearchAct.setLayoutManager(horizontalLayoutManager);
        SearchActHorizontalAdapter searchActHorizontalAdapter = new SearchActHorizontalAdapter(horizontalImg,SearchActivty.this);
        horizontalRecViewSearchAct.setAdapter(searchActHorizontalAdapter);



        if(visStatus == 1){
            citySelectedRel.setVisibility(View.VISIBLE);
        }
        if(visStatus == 0){
            citySelectedRel.setVisibility(View.INVISIBLE);
        }

        citySelectCancelBTn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citySelectedRel.setVisibility(View.INVISIBLE);
                visStatus = 0;
            }
        });


        visStatus = 0;


    }


}