package com.example.mobileproject

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject.Classes.User
import com.example.mobileproject.UserDataManager

class StatisticsFragment(private val userDataManager: UserDataManager) : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RankAdapter
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

        val userList: List<User> = userDataManager.fetchDataAndCreateUsers()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RankAdapter(userList)
    }
}