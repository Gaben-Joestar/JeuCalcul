package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer;
    private Button boutonScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonJouer =findViewById(R.id.boutonJouer);
        boutonScores=findViewById(R.id.boutonScores);

        boutonJouer.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,GameActivity.class);
            startActivity(intent);
        });

        boutonScores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent);
        });
    }



}