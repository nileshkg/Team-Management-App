package com.example.pplapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "team_table")
public class TeamData {

    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String team;
    private String owner;
    private int age;
    private  int members;

    public TeamData(String team, String owner, int age, int members) {
        this.team = team;
        this.owner = owner;
        this.age = age;
        this.members = members;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getOwner() {
        return owner;
    }

    public int getAge() {
        return age;
    }

    public int getMembers() {
        return members;
    }
}
