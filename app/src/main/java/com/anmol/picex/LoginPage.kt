package com.anmol.picex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val temp = intent.getStringExtra("Passcode")

        button = findViewById(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this@LoginPage,temp, Toast.LENGTH_SHORT).show()
        }
    }
}