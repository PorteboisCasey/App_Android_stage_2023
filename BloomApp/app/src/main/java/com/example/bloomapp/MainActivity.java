package com.example.bloomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button buttonBowling;
    private LinearLayout historiqueLinearLayout;
    private ArrayList<Integer> historique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.Button);
        buttonBowling = findViewById(R.id.button_bowling);
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

        buttonBowling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstBall = new Random().nextInt(10) + 1;
                int secondBall = new Random().nextInt(10 - firstBall + 1);
                int score = firstBall + secondBall;
                boolean split = checkSplit(firstBall, secondBall);

                int playerId = new Random().nextInt(1000);
                String playerName = "Casey";
                String playerSurname = "Portebois";
                Player player = new Player(playerId, playerName, playerSurname);

                int gameId = new Random().nextInt(1000);
                int gameScore = new Random().nextInt(300);
                boolean gameComplete = new Random().nextBoolean();
                Game game = new Game(gameId, gameScore, gameComplete);

                Bowling bowling = new Bowling(firstBall, secondBall, score, split, player, game);
                Intent intent = new Intent(MainActivity.this, DestinationActivity.class);
                intent.putExtra("bowling", bowling);
                startActivity(intent);
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

    private boolean checkSplit(int firstBall, int secondBall) {
        if (firstBall == 10) {
            return true;
        } else {
            return false;
        }
    }
}