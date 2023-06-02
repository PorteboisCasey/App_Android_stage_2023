package com.example.viewrecyclerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);

        holder.personNameTextView.setText(person.getFirstName() + " " + person.getLastName());
        holder.personIdTextView.setText(String.valueOf(person.getId()));
        holder.personImageView.setImageResource(person.getImageId());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView personNameTextView;
        TextView personIdTextView;
        ImageView personImageView;

        PersonViewHolder(View itemView) {
            super(itemView);
            personNameTextView = itemView.findViewById(R.id.personNameTextView);
            personIdTextView = itemView.findViewById(R.id.personIdTextView);
            personImageView = itemView.findViewById(R.id.personImageView);
        }
    }
}
