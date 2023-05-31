package com.example.bloomapp; // Remplacez com.example.bloomapp par le nom de votre propre package

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private LinearLayout historiqueLinearLayout;
    private ArrayList<Integer> historique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.Button);
        historiqueLinearLayout = findViewById(R.id.historiqueLinearLayout);

        historique = new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valeur = new Random().nextInt(100);
                historique.add(valeur);
                if (historique.size() > 10) {
                    historique.remove(0);
                }
                afficherHistorique();
            }
        });
    }

    private void afficherHistorique() {
        historiqueLinearLayout.removeAllViews();

        for (int i = 0; i < historique.size(); i++) {
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(historique.get(i)));
            historiqueLinearLayout.addView(textView);
        }
    }
}
