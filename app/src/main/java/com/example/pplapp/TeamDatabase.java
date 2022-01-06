package com.example.pplapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {TeamData.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase teamDatabase;
    public abstract TeamDAO teamDAO();
    public static synchronized TeamDatabase getInstance(Context context){
        if(teamDatabase == null){
            teamDatabase = Room.databaseBuilder(context.getApplicationContext(),TeamDatabase.class, "team_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return  teamDatabase;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new  PopulateDbAsyncTask(teamDatabase).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private TeamDAO teamDAO;

        private PopulateDbAsyncTask(TeamDatabase db){
            teamDAO = db.teamDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            teamDAO.insert(new TeamData("team 1","owner 1",1,1));
            teamDAO.insert(new TeamData("team 2","owner 2",2,2));
            teamDAO.insert(new TeamData("team 3","owner 3", 3,3));
            return null;
        }
    }

}
