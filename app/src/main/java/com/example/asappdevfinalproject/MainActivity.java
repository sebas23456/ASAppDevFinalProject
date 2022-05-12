package com.example.asappdevfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LoginBase db;

    public void openActivityHomepage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = findViewById(R.id.textViewUsername);
        TextView pass = findViewById(R.id.textViewPassword);

        Button login = (Button) findViewById(R.id.buttonLogin);
        login.setOnClickListener(v -> {
            db = new LoginBase(MainActivity.this);
            String u = username.getText().toString();
            String p = pass.getText().toString();
            if (db.check(u,p) != null){
             openActivityHomepage();
             finish();
            } else {
                Toast.makeText(MainActivity.this, "The credentials you have entered are incorrect",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }



}