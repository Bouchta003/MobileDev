package com.example.mobileproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }

    }

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
        val buttona = view.findViewById<Button>(R.id.abutton)
        val buttonb = view.findViewById<Button>(R.id.bbuton)
        val buttonc = view.findViewById<Button>(R.id.cbutton)
        val buttond = view.findViewById<Button>(R.id.dbutton)
        //Pour la personne responsable de la réaction des boutons en fonction de la question:
        //Changer la condition du if de chaque Listener pour vérifier:
        buttona.setOnClickListener {
            if(true){
            val newFragment = Reponses.newInstance("New", "Fragment")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
            }
        }
        buttonb.setOnClickListener {
            if(true){
            val newFragment = Reponses.newInstance("New", "Fragment")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()
            }
        }
        buttonc.setOnClickListener {if(true){
            val newFragment = Reponses.newInstance("New", "Fragment")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()}
        }
        buttond.setOnClickListener {if(true){
            val newFragment = Reponses.newInstance("New", "Fragment")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, newFragment)
                .addToBackStack(null)
                .commit()}
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Questions.
         */
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