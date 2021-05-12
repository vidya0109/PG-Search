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

public class PgOwnerReg extends AppCompatActivity {

    EditText pgname , pgownername , pgowneremail , aadharno , pgregid, pgownerpass;
    FirebaseAuth firebaseAuth;
    String email , pass;
    TextView textView;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_owner_reg);

        pgname = findViewById(R.id.pg_reg_name);
        pgownername = findViewById(R.id.pg_owner_reg_name);
        pgowneremail = findViewById(R.id.pg_owner_reg_email);
        aadharno = findViewById(R.id.aadhar_no);
        pgregid = findViewById(R.id.pg_reg_id);
        pgownerpass = findViewById(R.id.pg_owner_reg_password);
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseAuth  = FirebaseAuth.getInstance();

        textView = findViewById(R.id.texxt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PgOwnerReg.this,PgOwnerLogin.class);
                startActivity(i);
                finish();

            }
        });




    }

    public void SignUp(View view){

        email = pgowneremail.getText().toString();
        pass = pgownerpass.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) ){

            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        PgOwner p = new PgOwner(pgname.getText().toString(),pgownername.getText().toString(),email,aadharno.getText().toString(),pgregid.getText().toString());
                        CollectionReference reference = firebaseFirestore.collection("PgOwner");
                        reference.document(firebaseAuth.getUid()).set(p).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Toast.makeText(getApplicationContext(), "Succesfully added your account", Toast.LENGTH_LONG).show();
                                sendtoMain();
                            }
                        });


                    }
                    else{

                        String error=task.getException().getMessage();
                        Toast.makeText(PgOwnerReg.this,error,Toast.LENGTH_LONG).show();
                    }
                }

            });


        }
        else{

            Toast.makeText(this,"Any field cannot be empty",Toast.LENGTH_LONG).show();

        }








    }
    public void sendtoMain() {

        Intent intent1 = new Intent(PgOwnerReg.this, MainActivity.class);
        startActivity(intent1);
        finish();

    }
}