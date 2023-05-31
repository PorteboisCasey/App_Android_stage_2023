package com.example.bloomapp;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import java.util.Random;



import androidx.appcompat.app.AppCompatActivity;

public class DestinationActivity extends AppCompatActivity {

    private TextView firstBallTextView;
    private TextView secondBallTextView;
    private TextView scoreTextView;
    private TextView splitTextView;
    private TextView playerNameTextView;
    private TextView playerSurnameTextView;
    private TextView gameIdTextView;
    private TextView gameScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        // Récupérer les références des TextView
        firstBallTextView = findViewById(R.id.tv_firstBall);
        secondBallTextView = findViewById(R.id.tv_secondBall);
        scoreTextView = findViewById(R.id.tv_score);
        splitTextView = findViewById(R.id.tv_split);
        playerNameTextView = findViewById(R.id.tv_player_name);
        playerSurnameTextView = findViewById(R.id.tv_player_surname);
        gameIdTextView = findViewById(R.id.tv_game_id);
        gameScoreTextView = findViewById(R.id.tv_game_score);

        // Obtenir les données du Intent
        Intent intent = getIntent();
        if (intent != null) {
            Bowling bowling = intent.getParcelableExtra("bowling");
            if (bowling != null) {
                // Afficher les données dans les TextView
                firstBallTextView.setText("First Ball: " + bowling.getFirstBall());
                secondBallTextView.setText("Second Ball: " + bowling.getSecondBall());
                scoreTextView.setText("Score: " + bowling.getScore());



            }
        }

        Player player = new Player(0,"Devil","ghj");
        Player player1 = new Player(1,"Joris","Victor");
        Player player2 = new Player(2,"Victor","Drassor");


        playerNameTextView.setText(player.getNom());
        playerSurnameTextView.setText(player.getPrenom());

        // Générer les valeurs aléatoires pour l'ID du jeu et le score du jeu


        Random random = new Random();
        int gameId = random.nextInt(101);
        int gameScore = random.nextInt(101);

        // Afficher les valeurs générées

        gameIdTextView.setText("Game ID: " + gameIdTextView.getId());
        gameScoreTextView.setText("Game Score: " + gameScoreTextView.getId());



    }
}
