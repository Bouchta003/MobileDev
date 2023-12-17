import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileproject.databinding.FragmentProfileBinding
import com.example.mobileproject.Classes.User
import com.example.mobileproject.UserDataManager


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

        val userDataManager = UserDataManager()
        userDataManager.fetchDataAndCreateUsers { users ->
            if (users != null && users.isNotEmpty()) {
                // Par exemple, afficher les informations du premier utilisateur
                updateUI(users.first())
            } else {
                showError("Aucun utilisateur trouvé ou erreur de chargement des données.")
            }
        }
    }

    private fun updateUI(user: User) {
        binding.textViewName.text = user.nom
        binding.textViewFirstName.text = user.username // Assurez-vous que c'est le champ correct
        binding.textViewService.text = user.service
        // Ici, vous pouvez ajouter plus de mises à jour UI en fonction des données utilisateur
    }

    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



