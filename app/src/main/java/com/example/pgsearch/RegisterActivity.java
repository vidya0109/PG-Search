package com.example.pgsearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    EditText emailid, passw , name;
    String email ="", pass="",name1="";
    FirebaseAuth firebaseAuth;
    TextView textView;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailid = findViewById(R.id.reg_email);
        passw = findViewById(R.id.reg_password);
        name = findViewById(R.id.reg_name);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        textView = findViewById(R.id.log_act_intent);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();


            }
        });

    }

    public void signup(View view){

        email = emailid.getText().toString();
        pass = passw.getText().toString();
        name1 = name.getText().toString();
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) ){

            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        User u = new User(email,name1);
                        CollectionReference reference = firebaseFirestore.collection("Users");
                        reference.document(firebaseAuth.getUid()).set(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Toast.makeText(getApplicationContext(), "Succesfully added your account", Toast.LENGTH_LONG).show();
                                sendtoMain();

                            }
                        });


                    }
                    else{

                        String error=task.getException().getMessage();
                        Toast.makeText(RegisterActivity.this,error,Toast.LENGTH_LONG).show();
                    }
                }

            });




        }
        else{

            Toast.makeText(this,"Any field cannot be empty",Toast.LENGTH_LONG).show();

        }
    }
    public void sendtoMain() {

        Intent intent1 = new Intent(RegisterActivity.this, MainActivity.class);
        intent1.putExtra("Type", "User");
        startActivity(intent1);
        finish();

    }






}