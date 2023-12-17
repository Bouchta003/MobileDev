package com.example.mobileproject
import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.random.Random


/*Dans le fragment ou l'activité ajouter ces lignes de coder
val url = "https://jsonplaceholder.org/users"
val networkThread = NetworkThread(url) { yourData ->
}

networkThread.start()
*/
//val url = "https://jsonplaceholder.org/users"

val url ="https://jsonplaceholder.typicode.com/users"
data class Onlineusers(
    val id: Int,
    val firstname : String,
    val lastname : String,
    val username : String,
    val password : String,
    val score: Int = Random.nextInt(1, 101)
){
    override fun toString(): String {
        return "User(id=$id, firstname='$firstname', lastname='$lastname', username='$username', score=$score)"
    }

}
class NetworkThread(private val url: String, private val callback: (Onlineusers?) -> Unit) : Thread() {

    override fun run() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        try {
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            val yourData = Gson().fromJson(json, Onlineusers::class.java)

            // Utilisez un Handler pour passer les données à l'interface utilisateur
            Handler(Looper.getMainLooper()).post {
                callback(yourData)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Handler(Looper.getMainLooper()).post {
                callback(null)
            }
        }
    }
}


