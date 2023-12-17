package com.example.mobileproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobileproject.Classes.Questions
import com.example.mobileproject.Classes.Questions.IniList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Questions.newInstance] factory method to
 * create an instance of this fragment.
 */
class Questions : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private val selectedQuestions = mutableListOf<Int>()
    val questionsList: List<Questions> = IniList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_questions, container, false)
        var textView = view.findViewById<TextView>(R.id.questiontxtid)
        if(param1==null)
        {textView.text="Question 1"}
        else
        {textView.text="Question "+param1}
        //Ini des questions et propositions:
        val randomQuestion = getRandomQuestion()
        val chosenQ=questionsList[randomQuestion]
        selectedQuestions.add(randomQuestion)
        //Ini des boutons :
        val buttona = view.findViewById<Button>(R.id.abutton)
        val buttonb = view.findViewById<Button>(R.id.bbuton)
        val buttonc = view.findViewById<Button>(R.id.cbutton)
        val buttond = view.findViewById<Button>(R.id.dbutton)
        //Ini Txt
        val texta = view.findViewById<TextView>(R.id.textViewA)
        val textb = view.findViewById<TextView>(R.id.textViewB)
        val textc = view.findViewById<TextView>(R.id.textViewC)
        val textd = view.findViewById<TextView>(R.id.textViewD)
        val textq = view.findViewById<TextView>(R.id.textViewQ)
        //
        textq.text=chosenQ.question
        texta.text=chosenQ.goodanswer
        textb.text=chosenQ.answer2
        textc.text=chosenQ.answer3
        textd.text=chosenQ.answer4
        //Pour la personne responsable de la réaction des boutons en fonction de la question:
        //Changer la condition du if de chaque Listener pour vérifier:
        buttona.setOnClickListener {
            val newFragment = Reponses.newInstance(chosenQ, true)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
        }
        buttonb.setOnClickListener {
            val newFragment = Reponses.newInstance(chosenQ, false)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
        }
        buttonc.setOnClickListener {
            val newFragment = Reponses.newInstance(chosenQ, false)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()}
        buttond.setOnClickListener {
            val newFragment = Reponses.newInstance(chosenQ, false)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
    private fun getRandomQuestion(): Int {
        val totalQuestions = questionsList.size

        if (selectedQuestions.size == totalQuestions) {
            selectedQuestions.clear()
        }
        var randomIndex: Int
        if (questionsList==null||questionsList.size==0){return 0}
        do {
            randomIndex = (0 until totalQuestions).random()
        } while (selectedQuestions.contains(randomIndex))

        return randomIndex
    }
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            Questions().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}