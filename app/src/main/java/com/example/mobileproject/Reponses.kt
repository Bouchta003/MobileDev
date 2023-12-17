package com.example.mobileproject

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobileproject.Classes.Questions

class Reponses : Fragment() {
    private lateinit var viewModel: ReponsesViewModel
    private lateinit var userDataManager: UserDataManager
    private lateinit var chosenQ: Questions
    private var isCorrect: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        viewModel = ViewModelProvider(requireActivity()).get(ReponsesViewModel::class.java)
        chosenQ = arguments?.getSerializable("chosenQ") as Questions
        isCorrect = arguments?.getBoolean("isCorrect") ?: false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reponses, container, false)
        val vraifauxID = view.findViewById<TextView>(R.id.vraifauxID)
        val qid = view.findViewById<TextView>(R.id.qid)
        val rid = view.findViewById<TextView>(R.id.rid)
        val exid = view.findViewById<TextView>(R.id.exid)
        val buttonnext = view.findViewById<Button>(R.id.nextbuttonid)

        if (isCorrect==true){
            vraifauxID.text="Vrai"
            vraifauxID.setTextColor(Color.parseColor("#006400"))
        } else{
            vraifauxID.text="Faux"
            vraifauxID.setTextColor(Color.RED)
        }
        qid.text=chosenQ.question
        rid.text = if (isCorrect) "Correct" else "Incorrect: ${chosenQ.goodanswer}"
        exid.text="Explication : "+chosenQ.justification

        buttonnext.setOnClickListener {
            viewModel.counter++

            if (viewModel.counter >= 11) {
                viewModel.counter = 0
                val newFragment = Score_Quiz_Fragment.newInstance(viewModel.score)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.actualfragment, newFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                val newFragment = com.example.mobileproject.Questions.newInstance(viewModel.counter)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.actualfragment, newFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(chosenQ: com.example.mobileproject.Classes.Questions, isCorrect: Boolean) =
            Reponses().apply {
                arguments = Bundle().apply {
                    putSerializable("chosenQ", chosenQ)
                    putBoolean("isCorrect", isCorrect)
                }
            }
    }
}

