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
import com.google.firebase.firestore.FirebaseFirestore;

public class PgOwnerLogin extends AppCompatActivity {

    EditText editText, editText2;
    String email, pass;
    FirebaseAuth firebaseAuth;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_owner_login);

        editText = findViewById(R.id.pg_owner_log_email);
        editText2 = findViewById(R.id.pg_owner_log_password);


        firebaseAuth = FirebaseAuth.getInstance();

        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(PgOwnerLogin.this, PgOwnerReg.class);
                startActivity(intent1);
                finish();


            }
        });


    }

    public void Login(View view) {

        email = editText.getText().toString();
        pass = editText2.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {

            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        sendtoMain();
                    } else {

                        String error = task.getException().getMessage();
                        Toast.makeText(PgOwnerLogin.this, error, Toast.LENGTH_LONG).show();

                    }
                }
            });
        } else {
            Toast.makeText(PgOwnerLogin.this, "Username or Password cannot be empty", Toast.LENGTH_LONG).show();

        }
    }

    public void sendtoMain() {

        Intent intent1 = new Intent(PgOwnerLogin.this, MainActivity.class);
        intent1.putExtra("Type" , "Owner");
        startActivity(intent1);
        finish();

    }

}