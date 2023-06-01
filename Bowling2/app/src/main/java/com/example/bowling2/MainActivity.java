package com.example.bowling2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Player> playerList;
    private int currentPlayerIndex;
    private TextView playerNameTextView;
    private TextView playerIdTextView;
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerNameTextView = findViewById(R.id.playerNameTextView);
        playerIdTextView = findViewById(R.id.playerIdTextView);
        scoreTextView = findViewById(R.id.scoreTextView);

        playerList = new ArrayList<>();
        currentPlayerIndex = -1;

        Button bowlingButton1 = findViewById(R.id.bowlingButton1);
        bowlingButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playerList.size() > 0) {
                    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
                    displayPlayer(currentPlayerIndex);
                }
            }
        });

        Button bowlingButton2 = findViewById(R.id.bowlingButton2);
        bowlingButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomPlayer();
                currentPlayerIndex = playerList.size() - 1;
                displayPlayer(currentPlayerIndex);
            }
        });
    }

    private void generateRandomPlayer()
    {
        Random random = new Random();

        String playerName = "Player " + (playerList.size() + 1);

        int randomScore = random.nextInt(200); //
        playerList.add(new BowlingPlayer(playerName, randomScore));
    }

    private void displayPlayer(int index) {
        if (index >= 0 && index < playerList.size())
        {
            Player currentPlayer = playerList.get(index);

            playerNameTextView.setText(currentPlayer.getPlayerName());
            playerIdTextView.setText("ID: " + (index + 1));
            scoreTextView.setText(String.valueOf(currentPlayer.getScore()));
        }
    }
}
