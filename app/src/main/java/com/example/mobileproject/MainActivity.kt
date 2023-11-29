package com.example.mobileproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//Ali

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //J'initie les variables concernées par l'activité, on utilise VAR et non pas VAL pour qu'elles puissent être modifiées
        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)
        var loginButton = findViewById<Button>(R.id.buttonlogin)
        //Ces values correspondent aux username/password à tester et vérifier
        val usertest = "testusername"
        val passwordtest = "testpassword"
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
                Toast.makeText(this@MainActivity, "Login successful, welcome !!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}