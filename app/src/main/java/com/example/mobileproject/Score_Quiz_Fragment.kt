package com.example.mobileproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Score_Quiz_Fragment : Fragment() {

    companion object {
        fun newInstance() = Score_Quiz_Fragment()
    }

    private lateinit var viewModel: ScoreQuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_score__quiz_, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScoreQuizViewModel::class.java)
        // TODO: Use the ViewModel
    }

}