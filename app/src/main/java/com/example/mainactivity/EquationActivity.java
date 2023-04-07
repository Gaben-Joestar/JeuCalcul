package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class EquationActivity extends AppCompatActivity {
    private String calcul = "";
    private int score = 0;
    private int nbVies = 3;
    private TextView textViewResultat;
    private TextView textViewCalcul;
    private TextView textViewNbVies;
    private TextView textViewNbScore;

    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button boutonSupprimer;
    private Button boutonEntrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        bouton0 = findViewById(R.id.bouton0);
        bouton1 = findViewById(R.id.bouton1);
        bouton2 = findViewById(R.id.bouton2);
        bouton3 = findViewById(R.id.bouton3);
        bouton4 = findViewById(R.id.bouton4);
        bouton5 = findViewById(R.id.bouton5);
        bouton6 = findViewById(R.id.bouton6);
        bouton7 = findViewById(R.id.bouton7);
        bouton8 = findViewById(R.id.bouton8);
        bouton9 = findViewById(R.id.bouton9);

        boutonEntrer = findViewById(R.id.boutonEntree);
        boutonSupprimer = findViewById(R.id.boutonSuppression);
        textViewResultat = findViewById(R.id.textViewResultat);
        textViewCalcul = findViewById(R.id.textViewCalcul);
        textViewNbScore = findViewById(R.id.textViewNbScore);
        textViewNbVies = findViewById(R.id.textViewNbVies);

        bouton0.setOnClickListener(view -> ajouterNombre("0"));
        bouton1.setOnClickListener(view -> ajouterNombre("1"));
        bouton2.setOnClickListener(view -> ajouterNombre("2"));
        bouton3.setOnClickListener(view -> ajouterNombre("3"));
        bouton4.setOnClickListener(view -> ajouterNombre("4"));
        bouton5.setOnClickListener(view -> ajouterNombre("5"));
        bouton6.setOnClickListener(view -> ajouterNombre("6"));
        bouton7.setOnClickListener(view -> ajouterNombre("7"));
        bouton8.setOnClickListener(view -> ajouterNombre("8"));
        bouton9.setOnClickListener(view -> ajouterNombre("9"));

        boutonEntrer.setOnClickListener(view -> verifierCalcul());

        boutonSupprimer.setOnClickListener(view -> supprimerNombre());
        genererCalcul();
        score = Integer.parseInt(textViewNbScore.getText().toString());



    }

    private void ajouterNombre(String nombre) {
        calcul += nombre;
        textViewResultat.setText(calcul);
    }
    private void supprimerNombre() {
        if (!calcul.isEmpty()) {
            calcul = calcul.substring(0, calcul.length() - 1);
            textViewResultat.setText(calcul);
        }
    }
    private void genererCalcul() {
        Random random = new Random();
        int nombre1 = random.nextInt(20)+1;
        int nombre2 = random.nextInt(20)+1;
        String operateur ="";
        int resultat = 0;

        if (nombre1-nombre2>=0 && nombre1%nombre2==0){
            String[] operateurs = {"+", "-", "*","/"};
            operateur = operateurs[random.nextInt(4)];
        } else if (nombre1-nombre2>=0 && nombre1%nombre2!=0) {
            String[] operateurs = {"+", "-", "*"};
            operateur = operateurs[random.nextInt(3)];
        } else if (nombre1-nombre2<0 && nombre1%nombre2==0) {
            String[] operateurs = {"+", "*", "/"};
            operateur = operateurs[random.nextInt(3)];
        }else {
            String[] operateurs = {"+","*"};
            operateur = operateurs[random.nextInt(2)];
        }

        switch (operateur) {
            case "+":
                resultat = nombre1 + nombre2;
                break;
            case "-":
                resultat = nombre1 - nombre2;
                break;
            case "*":
                resultat = nombre1 * nombre2;
                break;
            case "/":
                resultat = nombre1 / nombre2;
                break;
        }

        String equation = nombre1 + " " + operateur + " " + "?" + " = " + resultat;
        textViewCalcul.setText(equation);
    }


    private void verifierCalcul(){
        String resultatString = textViewResultat.getText().toString();
        int resultat = Integer.parseInt(resultatString);
        int equation = getTexteEquationEnEntier();
        textViewResultat.setText("");

        if (resultat == equation){
            score = score + 1;
            textViewNbScore.setText(String.valueOf(score));
        }
        else {
            nbVies = nbVies - 1;
            textViewNbVies.setText(String.valueOf(nbVies));
        }
        if(nbVies==0){
            Intent intent = new Intent(EquationActivity.this, EndActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }else {
            genererCalcul();
        }
    }


    private int getTexteEquationEnEntier() {
        String texteEquation = textViewCalcul.getText().toString();
        String[] elements = texteEquation.split(" ");
        String operateur = elements[1];
        int nombre1 = Integer.parseInt(elements[0]);
        int nombre2 = Integer.parseInt(elements[4]);

        switch (operateur) {
            case "+":
                return nombre1 + nombre2;
            case "-":
                return nombre1 - nombre2;
            case "*":
                return nombre1 * nombre2;
            case "/":
                return nombre1 / nombre2;
            default:
                return 0;
        }
    }
}