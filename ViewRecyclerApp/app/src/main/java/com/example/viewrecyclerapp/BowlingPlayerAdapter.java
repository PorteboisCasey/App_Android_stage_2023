package com.example.viewrecyclerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BowlingPlayerAdapter extends RecyclerView.Adapter<BowlingPlayerAdapter.PlayerViewHolder> {
    private final List<BowlingPlayer> playerList;

    public BowlingPlayerAdapter(List<BowlingPlayer> playerList) {
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bowling_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        BowlingPlayer player = playerList.get(position);

        holder.playerIdTextView.setText(String.valueOf(player.getId()));
        holder.playerNameTextView.setText(player.getFirstName() + " " + player.getLastName());
        holder.scoreTextView.setText(String.valueOf(player.getScore()));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        public TextView playerIdTextView;
        public TextView playerNameTextView;
        public TextView scoreTextView;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            playerIdTextView = itemView.findViewById(R.id.playerIdTextView);
            playerNameTextView = itemView.findViewById(R.id.playerNameTextView);
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
        }
    }
}
