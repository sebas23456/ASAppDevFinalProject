package com.example.asappdevfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public void openActivitySecond() {
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(view -> openActivitySecond());

    }



}