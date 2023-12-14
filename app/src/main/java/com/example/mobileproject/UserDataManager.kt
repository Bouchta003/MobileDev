package com.example.mobileproject

import android.os.Parcelable
import com.example.mobileproject.Classes.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject

class UserDataManager {
    fun fetchDataAndCreateUsers(): List<User> {
        val responseData = fetchdata()
        val userList = mutableListOf<User>()

        if (responseData != null) {
            val jsonArray = JSONArray(responseData)
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


    fun fetchdata(): String? {
        val url = "https://jsonplaceholder.org/users" // Remplacez l'URL par celle de votre API ou source de données

        val client = OkHttpClient() // Définition et initialisation de la variable client

        val request = Request.Builder()
            .url(url)
            .build()

        return try {
            val response: Response = client.newCall(request).execute()
            if (response.isSuccessful) {
                response.body?.string()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

}