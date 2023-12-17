package com.example.mobileproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class Score_Quiz_Fragment : Fragment() {

    companion object {
        private const val USER_SCORE_KEY = "user_score"
        fun newInstance(score : Int) = Score_Quiz_Fragment().apply{
            arguments = Bundle().apply{
                putInt(USER_SCORE_KEY,score)
            }
        }
    }

    private lateinit var viewModel: ScoreQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_score__quiz_, container, false)

        val score = arguments?.getInt(USER_SCORE_KEY) ?: 0

        val scoreTextView = view.findViewById<TextView>(R.id.scoreView)
        scoreTextView.text="$score / 10"

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