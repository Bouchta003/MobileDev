package com.example.mobileproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.ui.theme.AdapterRanking


class Menu_Activity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        val items: MutableList<RankingContent.RankingItem> = ArrayList()
        items.add(RankingContent.RankingItem(1, "John", "Wick", 100))
        items.add(RankingContent.RankingItem(2, "Robert", "Smith", 90))
        items.add(RankingContent.RankingItem(3, "James", "Gunn", 85))
        items.add(RankingContent.RankingItem(4, "Ricky", "Tales", 80))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRanking(applicationContext, items)
    }
}