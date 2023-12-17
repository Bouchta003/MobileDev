package com.example.mobileproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.Classes.User

class StatisticsFragment(private val userDataManager: UserDataManager) : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userList: List<User>

    companion object {
        fun newInstance(userDataManager: UserDataManager): StatisticsFragment {
            return StatisticsFragment(userDataManager)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_statistics, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userDataManager.fetchDataAndCreateUsers { userList ->
            activity?.runOnUiThread {
                if (userList != null) {
                    this.userList = userList
                    recyclerView.layoutManager = LinearLayoutManager(requireActivity())
                    recyclerView = view.findViewById(R.id.recyclerView)
                    val recyclerAdapter = RecyclerAdapter(userList)
                    recyclerView.adapter = recyclerAdapter

                } else {
                    // Gestion de l'erreur lors de la récupération des données
                }
            }
        }
    }
}