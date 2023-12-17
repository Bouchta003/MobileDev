package com.example.mobileproject
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.Classes.User

class RankAdapter(private var userList: ArrayList<User>) : RecyclerView.Adapter<RankAdapter.ViewHolder>() {

    init {
        // Trier la liste des utilisateurs par score décroissant
        userList = userList.sortedByDescending { it.score } as ArrayList<User>

        // Donner un classement (rank) à chaque utilisateur
        for ((index, user) in userList.withIndex()) {
            user.rank = index + 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rank_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        holder.rankView.text = user.rank.toString()
        holder.nameView.text = user.prenom
        holder.lastNameView.text = user.nom
        holder.scoreView.text = user.score.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rankView: TextView = itemView.findViewById(R.id.rankView)
        val nameView: TextView = itemView.findViewById(R.id.nameView)
        val lastNameView: TextView = itemView.findViewById(R.id.lastNameView)
        val scoreView: TextView = itemView.findViewById(R.id.scoreView)
    }
}