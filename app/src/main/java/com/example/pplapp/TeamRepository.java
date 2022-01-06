package com.example.pplapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TeamRepository {
    private TeamDAO teamDAO;
    public LiveData<List<TeamData>> allTeams;

    public TeamRepository(Application application){
        TeamDatabase teamDatabase = TeamDatabase.getInstance(application);
        teamDAO = teamDatabase.teamDAO();
        allTeams =teamDAO.getAllTeams();
    }

    public  void  insert(TeamData teamData){
        new InsertTeamAsyncTask(teamDAO).execute(teamData);

    }

    public  void update(TeamData teamData){
        new UpdateTeamAsyncTask(teamDAO).equals(teamData);
    }

    public void delete(TeamData teamData){
        new DeleteTeamAsyncTask(teamDAO).execute(teamData);
    }

    public void deleteAllTeams(){
        new DeleteAllTeamsAsyncTask(teamDAO).execute();
    }

    public LiveData<List<TeamData>> getAllTeams() {
        return allTeams;
    }

    private static class InsertTeamAsyncTask extends AsyncTask<TeamData, Void, Void>{
        private TeamDAO teamDAO;

        private InsertTeamAsyncTask(TeamDAO teamDAO){
            this.teamDAO = teamDAO;
        }

        @Override
        protected Void doInBackground(TeamData... teamData) {
            teamDAO.insert(teamData[0]);
            return null;
        }
    }

    private static class UpdateTeamAsyncTask extends AsyncTask<TeamData, Void, Void>{
        private TeamDAO teamDAO;

        private UpdateTeamAsyncTask(TeamDAO teamDAO){
            this.teamDAO = teamDAO;
        }

        @Override
        protected Void doInBackground(TeamData... teamData) {
            teamDAO.update(teamData[0]);
            return null;
        }
    }

    private static class DeleteTeamAsyncTask extends AsyncTask<TeamData, Void, Void>{
        private TeamDAO teamDAO;

        private DeleteTeamAsyncTask(TeamDAO teamDAO){
            this.teamDAO = teamDAO;
        }

        @Override
        protected Void doInBackground(TeamData... teamData) {
            teamDAO.delete(teamData[0]);
            return null;
        }
    }

    private static class DeleteAllTeamsAsyncTask extends AsyncTask<Void, Void, Void>{
        private TeamDAO teamDAO;

        private DeleteAllTeamsAsyncTask(TeamDAO teamDAO){
            this.teamDAO = teamDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            teamDAO.deleteAllTeams();
            return null;
        }
    }
}
