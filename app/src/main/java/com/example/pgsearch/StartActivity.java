package com.example.pgsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button loginActivityUser,regActivityUser,loginActivityOwner,regActivityOwner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loginActivityUser = findViewById(R.id.login_btn_start);
        regActivityUser = findViewById(R.id.reg_btn_start);
        loginActivityOwner = findViewById(R.id.login_btn_start_owner);
        regActivityOwner = findViewById(R.id.reg_btn_start_owner);



        loginActivityUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        regActivityUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        loginActivityOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,PgOwnerLogin.class);
                startActivity(intent);
                finish();
            }
        });

        regActivityOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,PgOwnerReg.class);
                startActivity(intent);
                finish();
            }
        });





    }
}