package com.example.pplapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {

    private List<TeamData> teamData = new ArrayList<>();

    @NonNull
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item, parent, false);
        return new TeamHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
         TeamData currentTeamData = teamData.get(position);
         holder.imageViewEditTeam.setImageResource(R.drawable.ic_baseline_edit_24);
         holder.textViewOwner.setText("Owner");
         holder.textViewTeam.setText("Team");
         holder.textViewOwnerName.setText(currentTeamData.getOwner());
         holder.textViewTeamName.setText(currentTeamData.getTeam());
         holder.imageViewPic.setImageResource(R.drawable.ic_baseline_add_24);

    }

    @Override
    public int getItemCount() {

        return teamData.size();
    }


    public void setTeamData(List<TeamData> teamData) {
        this.teamData = teamData;
        notifyDataSetChanged();

    }


    class TeamHolder extends  RecyclerView.ViewHolder {
        private TextView textViewOwner;
        private TextView textViewOwnerName;
        private TextView textViewTeam;
        private TextView textViewTeamName;
        private ImageView imageViewEditTeam;
        private ImageView imageViewPic;

        public TeamHolder(View itemView){
            super(itemView);
            textViewOwner = itemView.findViewById(R.id.textViewOwner);
            textViewOwnerName = itemView.findViewById(R.id.textViewOwnerName);
            textViewTeamName = itemView.findViewById(R.id.textViewTeamName);
            textViewTeam = itemView.findViewById(R.id.textViewTeam);
            imageViewPic = itemView.findViewById(R.id.imageViewPic);
            imageViewEditTeam = itemView.findViewById(R.id.imageViewEditTeam);

        }
    }
}
