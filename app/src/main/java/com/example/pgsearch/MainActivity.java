package com.example.pgsearch;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pgsearch.Adapters.StaggeredAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    LinearLayout linearLayout;
    TextView textView,textView2,searchBar;
    RecyclerView staggeredRecyclerView;
    FirebaseFirestore firebaseFirestore;

    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.delhi4, R.drawable.kolkata4, R.drawable.srinagar4, R.drawable.jaipur4,
            R.drawable.bengaluru4));

    String name , email , type = "";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.navmenu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        linearLayout = findViewById(R.id.navHeader);
        nav = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        View hView =  navigationView.getHeaderView(0);
        textView = (TextView)hView.findViewById(R.id.name);
        textView2 = (TextView)hView.findViewById(R.id.email);
        firebaseFirestore = FirebaseFirestore.getInstance();
        textView.setText("Profile name");
        textView2.setText("Email");
        searchBar = findViewById(R.id.search_bar);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivty.class);
                startActivity(intent);
            }
        });


        staggeredRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewStaggered);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        staggeredRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        StaggeredAdapter adapter = new StaggeredAdapter(MainActivity.this, images);
        staggeredRecyclerView.setAdapter(adapter);



        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivty.class);
                startActivity(intent);
            }
        });



        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext(), "Home Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_call:
                        firebaseAuth.signOut();
                        sendtoStart();
                        break;

                    case R.id.menu_setting:
                        Toast.makeText(getApplicationContext(), "Setting Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }


        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user==null){

            sendtoStart();
        }

    }

    public void sendtoStart(){

        Intent i = new Intent(MainActivity.this,StartActivity.class);
        startActivity(i);
        finish();


    }
    public void signout(View view){

        firebaseAuth.signOut();
        sendtoStart();

    }

}