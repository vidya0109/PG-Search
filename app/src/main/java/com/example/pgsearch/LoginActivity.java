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

public class LoginActivity extends AppCompatActivity {

    EditText emailid, passw;
    String email , pass;
    FirebaseAuth firebaseAuth;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailid = findViewById(R.id.log_email_);
        passw = findViewById(R.id.log_password_);

        firebaseAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.reg_act_intent);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();


            }
        });

    }

    public void login(View view){

        email = emailid.getText().toString();
        pass = passw.getText().toString();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {

            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        sendtoMain();
                    } else {

                        String error = task.getException().getMessage();
                        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_LONG).show();

                    }
                }
            });
        } else {
            Toast.makeText(LoginActivity.this, "Username or Password cannot be empty", Toast.LENGTH_LONG).show();

        }
    }

    public void sendtoMain() {

        Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
        intent1.putExtra("Type", "User");
        startActivity(intent1);
        finish();

    }

}