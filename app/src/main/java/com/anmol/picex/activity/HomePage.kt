package com.anmol.picex.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anmol.picex.R
import com.anmol.picex.adapter.HomeRecyclerAdapter

class HomePage : AppCompatActivity() {
    lateinit var logouthome: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var recyclerhome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val nameList = arrayListOf<String>("Anmol","Shruti","Arshiya","Abhi","Love","Jai","Somya")
    val desiList = arrayListOf<String>("MySelf", "Girlfriend","Panda","Aashique","PlayBoy","Jhatu Balak", "Motuu")
    lateinit var recyclerAdapter: HomeRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        logouthome = findViewById(R.id.logouthome)
        recyclerhome = findViewById(R.id.recyclerhome)
        layoutManager = LinearLayoutManager(this@HomePage)
        recyclerAdapter = HomeRecyclerAdapter(this@HomePage as Context, nameList, desiList)
        recyclerhome.adapter = recyclerAdapter
        recyclerhome.layoutManager = layoutManager


        logouthome.setOnClickListener {
            savepreference()
            startActivity(Intent(this@HomePage, LoginPage::class.java))

        }
    }
    fun savepreference(){
        sharedPreferences.edit().putBoolean("isLoggedIn",false).apply()
    }
}