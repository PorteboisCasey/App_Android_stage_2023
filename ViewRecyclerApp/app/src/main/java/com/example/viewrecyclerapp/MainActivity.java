package com.example.viewrecyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private List<Person> personList;

    private EditText idEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Button addButton;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ajout du diviseur
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        personList = new ArrayList<>();

        personAdapter = new PersonAdapter(personList);
        recyclerView.setAdapter(personAdapter);

        idEditText = findViewById(R.id.idEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        addButton = findViewById(R.id.addButton);
        resetButton = findViewById(R.id.resetButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les valeurs saisies par l'utilisateur

                int id = Integer.parseInt(idEditText.getText().toString());
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();

                Person person = new Person(id, firstName, lastName, R.drawable.bowling);

                // Ajouter la personne à la liste
                personList.add(person);

                // Notifier l'adaptateur des changements effectués dans la liste
                personAdapter.notifyDataSetChanged();

                // Effacer les champs de saisie par rapport au bouton reset
                idEditText.setText("");
                firstNameEditText.setText("");
                lastNameEditText.setText("");
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Supprimer tous les joueurs de la liste
                personList.clear();

                // Notifier l'adaptateur des changements effectués dans la liste
                personAdapter.notifyDataSetChanged();
            }
        });
    }
}