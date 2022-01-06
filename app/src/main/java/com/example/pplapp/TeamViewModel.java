package com.example.pplapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Update;

import java.util.List;

public class TeamViewModel extends AndroidViewModel {

    private  TeamRepository teamRepository;
    private LiveData<List<TeamData>> allTeams;

    public TeamViewModel(@NonNull Application application) {
        super(application);
        teamRepository = new TeamRepository(application);
        allTeams = teamRepository.getAllTeams();
    }
        public void insert(TeamData teamData){

        teamRepository.insert(teamData);
        }

        public void update(TeamData teamData){
            teamRepository.update(teamData);

        }

       public void delete(TeamData teamData){
            teamRepository.delete(teamData);

        }
        public void deleteAllTeams(){

        teamRepository.deleteAllTeams();
        }

        public LiveData<List<TeamData>> getAllTeams(){

        return allTeams;
        }

}
