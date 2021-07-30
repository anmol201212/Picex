package com.anmol.picex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    lateinit var loginbt: Button
    lateinit var passcodetxt: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var forgotbt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if(isLoggedIn){
            val intent = Intent ( this@LoginPage, HomePage::class.java)
            startActivity(intent)
            finish()
        }
        val temp = intent.getStringExtra("Passcode")
        loginbt = findViewById(R.id.loginbt)
        passcodetxt = findViewById(R.id.passcodetxt)
        forgotbt = findViewById(R.id.forgotbt)

        loginbt.setOnClickListener {
            val passcodesp = sharedPreferences.getString("passwordsp", "1234")
            val password = passcodetxt.text.toString()
            if(password == passcodesp){
                savepreference()
                startActivity(Intent(this@LoginPage, HomePage::class.java))
            }

            else{
                Toast.makeText(this@LoginPage,"Enter the details", Toast.LENGTH_SHORT).show()
            }
        }
        forgotbt.setOnClickListener {
            forgotpreference()
            startActivity(Intent(this@LoginPage, MainRegister::class.java))
        }
    }
    fun savepreference(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }
    fun forgotpreference(){
        sharedPreferences.edit().putBoolean("isresIn", false).apply()
    }
}