package com.example.mobileproject;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileproject.Classes.User;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<User> userList;

    private void initializeRanking(List<User> userList) {
        // Trier la liste des utilisateurs par score décroissant
        Collections.sort(userList, (user1, user2) -> Integer.compare(user2.getScore(), user1.getScore()));

        // Donner un classement (rank) à chaque utilisateur
        for (int i = 0; i < userList.size(); i++) {
            userList.get(i).setRank(i + 1);
        }
    }

    public RecyclerAdapter(List<User> userList){
        User adminUser = new User("Bernard", "Nicolas", "Cybersecurity", "admin", "admin");
        adminUser.setId(0);
        adminUser.setScore(45);

        userList.add(adminUser);
        this.userList = userList;
        initializeRanking(userList);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.item_rank_view, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.rank.setText(String.valueOf(user.getRank()));
        holder.name.setText(user.getPrenom());
        holder.lastname.setText(user.getNom());
        holder.score.setText(String.valueOf(user.getScore()));

        if (user.getId() == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.adminUserColor));
        } else {
            // Réinitialiser le style pour les autres utilisateurs
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rank;
        TextView name;
        TextView lastname;
        TextView score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.rankView);
            name = itemView.findViewById(R.id.nameView);
            lastname = itemView.findViewById(R.id.lastNameView);
            score = itemView.findViewById(R.id.scoreView);

        }
    }
}
