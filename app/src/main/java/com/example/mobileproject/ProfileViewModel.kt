import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileproject.Classes.User
import com.example.mobileproject.UserDataManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel : ViewModel() {

    private val userDataManager = UserDataManager()
    private lateinit var userList: ArrayList<User>
    var onDataReadyCallback: (() -> Unit)? = null

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Rechercher l'utilisateur avec id = 0 (admin) dans la liste des utilisateurs
                val admin = userList.find { it.getId() == 0 }

                // Appeler les fonctions nécessaires dans votre autre classe
                if (admin != null) {
                    withContext(Dispatchers.Main) {
                        // Appeler vos fonctions ici (par exemple, updateUI(admin))
                        onDataReadyCallback?.invoke()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        // Gérer le cas où l'utilisateur admin n'est pas trouvé
                        onDataReadyCallback?.invoke()
                    }
                }
            } catch (e: Exception) {
                // Gérer les erreurs lors de la récupération des données
                withContext(Dispatchers.Main) {
                    // Gérer les erreurs ici si nécessaire
                    onDataReadyCallback?.invoke()
                }
            }
        }
    }
}
