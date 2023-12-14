package com.example.mobileproject.ui.theme

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.R
import com.example.mobileproject.RankingContent


class AdapterRanking(private val context: Context, private val items: MutableList<RankingContent.RankingItem>) : RecyclerView.Adapter<RankingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rank_view, parent, false)
        return RankingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val item = items[position]
        holder.rankView.text = item.rank.toString()
        holder.nameView.text = item.name
        holder.lastNameView.text = item.lastName
        holder.scoreView.text= item.score.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}