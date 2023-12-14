package com.example.mobileproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

class Reponses : Fragment() {
    private lateinit var viewModel: ReponsesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        viewModel = ViewModelProvider(requireActivity()).get(ReponsesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reponses, container, false)

        val buttonnext = view.findViewById<Button>(R.id.nextbuttonid)
        buttonnext.setOnClickListener {
            viewModel.counter++

            if (viewModel.counter >= 11) {
                viewModel.counter = 0
                val newFragment = Score_Quiz_Fragment.newInstance()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.actualfragment, newFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                val newFragment = Questions.newInstance(viewModel.counter)
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
        fun newInstance(param1: String, param2: String) =
            Reponses().apply {
                arguments = Bundle().apply {
                }
            }
    }
}

