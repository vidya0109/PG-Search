package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pgsearch.Adapters.PreviousBookingsAdapter;
import com.example.pgsearch.Adapters.reviewAdapter;
import com.example.pgsearch.JavaModels.PreviousBookingsInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PreviousBookings extends AppCompatActivity {

    RecyclerView reviewRecViewAct;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    ArrayList<PreviousBookingsInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_bookings);
        reviewRecViewAct = findViewById(R.id.review_rec_view_rec_act);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        reviewRecViewAct.setLayoutManager(linearLayoutManager);

        list = new ArrayList<PreviousBookingsInfo>();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Users").document(firebaseAuth.getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                String name = documentSnapshot.get("name").toString();
                String previous = documentSnapshot.get("previous").toString();
                PreviousBookingsInfo p = new PreviousBookingsInfo(name,previous);
                list.add(p);




            }
        });
        PreviousBookingsAdapter previousBookingsAdapter = new PreviousBookingsAdapter(PreviousBookings.this,list);
        reviewRecViewAct.setAdapter(previousBookingsAdapter);

    }
}