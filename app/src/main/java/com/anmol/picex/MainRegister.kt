package com.anmol.picex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainRegister : AppCompatActivity() {

    lateinit var nametxt: EditText
    lateinit var passcode: EditText
    lateinit var registerbt: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//     func1    Register screen will not show again
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isresIn = sharedPreferences.getBoolean("isresIn", false)
        setContentView(R.layout.activity_login_page)
        if(isresIn){
            val intent = Intent ( this@MainRegister, LoginPage::class.java)
            startActivity(intent)
            finish()
        }
//        func1 ends

        setContentView(R.layout.register_main)

        nametxt = findViewById(R.id.nametxt)
        passcode = findViewById<EditText>(R.id.passcode)
        registerbt = findViewById(R.id.registerbt)


        registerbt.setOnClickListener {
            val intent = Intent(this@MainRegister, LoginPage::class.java)
            val pass: String? = passcode.text.toString()
            val nameid: String? = nametxt.text.toString()
            if(nameid != null && pass != null && nameid!="" && pass != ""){
                savepreference(pass)
                intent.putExtra("Passcode", pass)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@MainRegister,"Enter the details", Toast.LENGTH_SHORT).show()
            }
//            Toast.makeText(this@MainRegister,pass, Toast.LENGTH_SHORT).show()


        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savepreference(passcode: String){
        sharedPreferences.edit().putBoolean("isresIn",true).apply()
        sharedPreferences.edit().putString("passwordsp",passcode).apply()
    }

}