package com.example.asappdevfinalproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public void openActivityHomepage() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    public void openActivitySignup() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleText = findViewById(R.id.textViewTitle);
        titleText.setTextColor(Color.BLACK);

        TextView usernameText = findViewById(R.id.textViewUsername);
        usernameText.setTextColor(Color.BLACK);

        TextView passwordText = findViewById(R.id.textViewPassword);
        passwordText.setTextColor(Color.BLACK);

        Button login = (Button) findViewById(R.id.buttonLogin);
        login.setOnClickListener(view -> openActivityHomepage());

        Button signup = (Button) findViewById(R.id.buttonSignup);
        signup.setOnClickListener(view -> openActivitySignup());

    }



}