import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileproject.Classes.User
import com.example.mobileproject.UserDataManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel : ViewModel() {

    private val userDataManager = UserDataManager()
    var users: List<User>? = null
    var onDataReadyCallback: (() -> Unit)? = null

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val fetchedUsers = userDataManager.fetchDataAndCreateUsers()
                withContext(Dispatchers.Main) {
                    users = fetchedUsers
                    onDataReadyCallback?.invoke()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    users = null
                    onDataReadyCallback?.invoke()
                }
            }
        }
    }
}
