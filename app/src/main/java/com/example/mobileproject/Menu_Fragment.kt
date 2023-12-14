package com.example.mobileproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Menu_Fragment : Fragment() {

    companion object {
        fun newInstance() = Menu_Fragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val buttonStart = view.findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.actualfragment, Questions())
                .commit()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
    }

}