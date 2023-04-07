package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import BaseDeDonnees.MaBase;

public class ScoreActivity extends AppCompatActivity {
    private ListView listViewScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        MaBase mabase = new MaBase(this);

        listViewScores = findViewById(R.id.listViewScores);

        // Récupération des données depuis la base de données
        Cursor cursor = mabase.getData();

        // Parcours de l'objet Cursor pour récupérer les données
        ArrayList<String> scoresList = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int score = cursor.getInt(cursor.getColumnIndex("score"));

            scoresList.add(id + ". " + name + ": " + score);
        }

        // Création de l'adapter pour la ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scoresList);
        listViewScores.setAdapter(adapter);

        // Fermeture de l'objet Cursor
        cursor.close();
    }
}
