package com.example.mobileproject
import com.example.mobileproject.databinding.FragmentProfileBinding


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val userName = "Anna"
        val userFirstName = "Avetisyan"
        val userService = "Développement"
        val userScore = "42"

        binding.textViewName.text = userName
        binding.textViewFirstName.text = userFirstName
        binding.textViewService.text = userService
        binding.textViewScore.text = "Score : $userScore"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


