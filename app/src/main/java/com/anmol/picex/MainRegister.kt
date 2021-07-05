package com.anmol.picex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainRegister : AppCompatActivity() {

    lateinit var nametxt: EditText
    lateinit var passcode: EditText
    lateinit var registerbt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_main)

        nametxt = findViewById(R.id.nametxt)
        passcode = findViewById(R.id.passcode) as EditText
        registerbt = findViewById(R.id.registerbt)
        val intent = Intent(this@MainRegister, LoginPage::class.java)
        val pass = passcode.text

        registerbt.setOnClickListener {
//            Toast.makeText(this@MainRegister,passcode.text, Toast.LENGTH_SHORT).show()

            intent.putExtra("Passcode", pass)
            startActivity(intent)

        }
    }
}