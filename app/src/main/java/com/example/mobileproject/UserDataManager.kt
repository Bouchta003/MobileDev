package com.example.mobileproject

import android.os.Handler
import android.os.Looper
import com.example.mobileproject.Classes.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray

class UserDataManager {
    fun fetchDataAndCreateUsers(callback: (ArrayList<User>?) -> Unit) {
        val url = "https://jsonplaceholder.typicode.com/users"

        val client = OkHttpClient()

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

    private fun parseJsonToUserList(json: String?): ArrayList<User>? {
        val userList = ArrayList<User>()

        if (json != null) {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val userObject = jsonArray.getJSONObject(i)

                val nom = userObject.getString("name")
                val prenom = userObject.getString("username")
                val service = userObject.getJSONObject("company").getString("bs")
                val password = userObject.getString("email")
                val username = userObject.getString("username")

                val user = User(nom, prenom, service, password, username)
                userList.add(user)
            }
        }

        return userList
    }
}
