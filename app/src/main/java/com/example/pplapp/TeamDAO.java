package com.example.pplapp;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeamDAO {

    @Insert
    void insert(TeamData teamData);

    @Update
    void update(TeamData teamData);

    @Delete
    void delete(TeamData teamData);

    @Query("DELETE FROM team_table")
    void deleteAllTeams();

    @Query("SELECT * FROM team_table ORDER BY id ASC")
    LiveData<List<TeamData>> getAllTeams();
}
