package com.example.mobileproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.ui.theme.AdapterRanking
import com.example.mobileproject.StatisticsFragment


class Menu_Activity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, Menu_Fragment())
                .commit()
        }

        val btnStatistics = findViewById<LinearLayout>(R.id.btnStatistics)
        val btnHome = findViewById<LinearLayout>(R.id.btnHome)
        val btnProfile = findViewById<LinearLayout>(R.id.btnProfile)

        btnStatistics.setOnClickListener {
            val userDataManager = UserDataManager()
            val statisticsFragment = StatisticsFragment.newInstance(userDataManager)
            replaceFragment(statisticsFragment)
        }

        btnHome.setOnClickListener {
            replaceFragment(Menu_Fragment())
        }

        btnProfile.setOnClickListener {
            replaceFragment(Score_Quiz_Fragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.actualfragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    /*
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        val items: MutableList<RankingContent.RankingItem> = ArrayList()
        items.add(RankingContent.RankingItem(1, "John", "Wick", 100))
        items.add(RankingContent.RankingItem(2, "Robert", "Smith", 90))
        items.add(RankingContent.RankingItem(3, "James", "Gunn", 85))
        items.add(RankingContent.RankingItem(4, "Ricky", "Tales", 80))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRanking(applicationContext, items)
        */

}