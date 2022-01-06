package com.example.pplapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TeamsActivity extends AppCompatActivity {


    private TeamViewModel teamViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        getSupportActionBar().hide();

        RecyclerView recyclerViewTeamList = findViewById(R.id.recyclerViewTeamList);
        recyclerViewTeamList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTeamList.setHasFixedSize(true);

        final TeamAdapter teamAdapter = new TeamAdapter();
        recyclerViewTeamList.setAdapter(teamAdapter);

        teamViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).
                get(TeamViewModel.class);
        teamViewModel.getAllTeams().observe(this, new Observer<List<TeamData>>() {
            @Override
            public void onChanged(List<TeamData> teamData) {

                Toast.makeText(TeamsActivity.this, "on changed", Toast.LENGTH_SHORT).show();
                teamAdapter.setTeamData(teamData);
            }
        });


        FloatingActionButton floatingButtonAdd = findViewById(R.id.floatingButtonAdd);

        floatingButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeamsActivity.this, CreateTeamActivity.class));
            }
        });



    }
}