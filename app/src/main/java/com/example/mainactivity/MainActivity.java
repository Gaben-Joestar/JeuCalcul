package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer;
    private Button boutonScores;

    private Button boutonApropos;
    private Button boutonEquations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonJouer =findViewById(R.id.boutonJouer);
        boutonScores=findViewById(R.id.boutonScores);
        boutonApropos=findViewById(R.id.boutonApropos);
        boutonEquations=findViewById(R.id.boutonEquations);

        boutonJouer.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,GameActivity.class);
            startActivity(intent);
        });

        boutonScores.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent);
        });

        boutonApropos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,AboutActivity.class);
            startActivity(intent);
        });
        boutonEquations.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,EquationActivity.class);
            startActivity(intent);
        });
    }


}