import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.mobileproject.databinding.FragmentProfileBinding
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    // Data model for the JSON response
    data class UserProfile(
        val userName: String,
        val userFirstName: String,
        val userService: String,
        val userScore: String
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fetch user data asynchronously
        fetchUserData()
    }

    private fun fetchUserData() {
        // Use lifecycleScope for coroutine to automatically cancel on fragment destroy
        lifecycleScope.launch {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/users") // replace with your URL
                    .build()

                val response = client.newCall(request).execute()
                val jsonData = response.body?.string()

                // Parse the JSON response
                val userProfile = jsonData?.let { Gson().fromJson(it, UserProfile::class.java) }

                // Update UI on the main thread
                userProfile?.let {
                    updateUI(it)
                } ?: showError("Failed to load user data")

            } catch (e: IOException) {
                showError("Error fetching user data: ${e.message}")
            }
        }
    }

    private fun updateUI(userProfile: UserProfile) {
        binding.textViewName.text = userProfile.userName
        binding.textViewFirstName.text = userProfile.userFirstName
        binding.textViewService.text = userProfile.userService
        binding.textViewScore.text = "Score: ${userProfile.userScore}"
    }

    private fun showError(message: String) {
        // Implement how you want to show error, e.g., using a Toast
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


