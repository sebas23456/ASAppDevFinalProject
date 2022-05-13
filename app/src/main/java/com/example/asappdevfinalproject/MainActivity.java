package com.example.asappdevfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LoginHelper db;

    public void openActivityHomepage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = findViewById(R.id.UsernameEntry);
        TextView pass = findViewById(R.id.PasswordEntry);

        Button login = (Button) findViewById(R.id.buttonLogin);
        login.setOnClickListener(v -> {
            db = new LoginHelper(MainActivity.this);
            String u = username.getText().toString();
            String p = pass.getText().toString();
            String id = db.check(u,p);
            if (id != null){
             openActivityHomepage();
            } else {
                Toast.makeText(MainActivity.this, "The credentials you have entered are incorrect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}