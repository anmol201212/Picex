package com.anmol.picex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomePage : AppCompatActivity() {
    lateinit var temp: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        temp = findViewById(R.id.temp)
        temp.setOnClickListener {
            savepreference()
            startActivity(Intent(this@HomePage, LoginPage::class.java))

        }
    }
    fun savepreference(){
        sharedPreferences.edit().putBoolean("isLoggedIn",false).apply()
    }
}