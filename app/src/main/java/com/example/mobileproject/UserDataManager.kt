package com.example.mobileproject

import android.os.Handler
import android.os.Looper
import com.example.mobileproject.Classes.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray

class UserDataManager {
    fun fetchDataAndCreateUsers(callback: (List<User>?) -> Unit) {
        val url = "https://jsonplaceholder.org/users" // Remplacez l'URL par celle de votre API ou source de données

        val client = OkHttpClient() // Définition et initialisation de la variable client

        val request = Request.Builder()
            .url(url)
            .build()

        val networkThread = object : Thread() {
            override fun run() {
                try {
                    val response: Response = client.newCall(request).execute()
                    val statusCode: Int = response.code

                    if (statusCode == 200) {
                        val json = response.body?.string()
                        val userList = parseJsonToUserList(json)
                        // Use a Handler to pass the data to the UI
                        Handler(Looper.getMainLooper()).post {
                            callback(userList)
                        }
                    } else {
                        Handler(Looper.getMainLooper()).post {
                            callback(null)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    Handler(Looper.getMainLooper()).post {
                        callback(null)
                    }
                }
            }
        }

        networkThread.start()
    }

    private fun parseJsonToUserList(json: String?): List<User>? {
        val userList = mutableListOf<User>()

        if (json != null) {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val userObject = jsonArray.getJSONObject(i)

                val nom = userObject.getString("lastname")
                val prenom = userObject.getString("firstname")
                val service = userObject.getString("bs")
                val password = userObject.getString("password")
                val username = userObject.getString("username")

                val user = User(nom, prenom, service, password, username)
                userList.add(user)
            }
        }

        return userList
    }
}