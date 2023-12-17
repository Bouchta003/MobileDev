
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileproject.Classes.User
import com.example.mobileproject.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var userList: ArrayList<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (::userList.isInitialized) {
            val admin = userList.find { it.id == 0 }
            if (admin != null) {
                // Utiliser la fonction updateUI pour mettre à jour l'interface utilisateur
                updateUI(admin)
            } else {
                showError("Aucun utilisateur trouvé.")
            }
        } else {
            val adminUser = User("Bernard", "Nicolas", "Cybersecurity", "admin", "admin")
            adminUser.setId(0)
            adminUser.setScore(45)
            userList = ArrayList()
            userList.add(adminUser)
            updateUI(adminUser)

            showError("Liste d'utilisateurs non initialisée.")
        }
    }

    private fun updateUI(user: User) {
        binding.textViewName.text = user.nom
        binding.textViewFirstName.text = user.prenom
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



