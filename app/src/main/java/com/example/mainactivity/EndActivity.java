package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import BaseDeDonnees.MaBase;

public class EndActivity extends AppCompatActivity {

    private Button buttonEnvoyer;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        MaBase mabase = new MaBase(this);

        editText=findViewById(R.id.editTextTextPersonName);

        buttonEnvoyer=findViewById(R.id.buttonEnvoyer);
        buttonEnvoyer.setOnClickListener(view -> {
            String name = editText.getText().toString();
            Bundle extras = getIntent().getExtras();
            int score = extras.getInt("score");
            mabase.insertData(name, score);
            Intent intent = new Intent(EndActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }

}