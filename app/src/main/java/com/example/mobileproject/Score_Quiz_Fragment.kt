package com.example.mobileproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mobileproject.StatisticsFragment

class Score_Quiz_Fragment : Fragment() {

    companion object {
        fun newInstance() = Score_Quiz_Fragment()
    }

    private lateinit var viewModel: ScoreQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_score__quiz_, container, false)

        val btnviewrank = view.findViewById<Button>(R.id.btnviewrank)
        btnviewrank.setOnClickListener {
            val userDataManager = UserDataManager()
            val newFragment = StatisticsFragment(userDataManager)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
        }

        val btngobackhome = view.findViewById<Button>(R.id.btngobackhome)
        btngobackhome.setOnClickListener {
            val newFragment = Menu_Fragment.newInstance()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScoreQuizViewModel::class.java)
    }
}