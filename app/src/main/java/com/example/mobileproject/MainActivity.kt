package com.example.mobileproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        //Shared Prefs
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val savedUsername = sharedPreferences.getString("username", "")
        if (savedUsername != null) {
            if (savedUsername.isNotEmpty()) {
                // User is logged in, proceed to the next activity
                val intent = Intent(this, Menu_Activity2::class.java)
                startActivity(intent)
                finish() // Optional: finish the current activity
            }
        }
        //J'initie les variables concernées par l'activité, on utilise VAR et non pas VAL pour qu'elles puissent être modifiées
        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)
        var loginButton = findViewById<Button>(R.id.buttonlogin)
        //Ces values correspondent aux username/password à tester et vérifier
        val usertest = "admin"
        val passwordtest = "admin"
        //Réaction du couton en fonction des inputs username et password:
        loginButton.setOnClickListener {
            val usertxt = username.text.toString()
            val passtxt = password.text.toString()
            if(usertxt!=usertest&&passtxt!=passwordtest){
                username.text=null
                password.text=null
                Toast.makeText(this@MainActivity, "Invalid username or, please try again", Toast.LENGTH_SHORT).show()
            }
            else{
                editor.putString("username", usertxt)
                editor.apply()

                Toast.makeText(this@MainActivity, "Login successful, welcome !!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Menu_Activity2::class.java)
                startActivity(intent)

            }
        }

    }



}