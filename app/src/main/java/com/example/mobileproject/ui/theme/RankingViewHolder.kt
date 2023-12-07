package com.example.mobileproject.ui.theme

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R

class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var rankView: TextView = itemView.findViewById(R.id.rankView)
    var nameView: TextView = itemView.findViewById(R.id.nameView)
    var lastNameView: TextView = itemView.findViewById(R.id.lastNameView)
    var scoreView: TextView = itemView.findViewById(R.id.scoreView)
}