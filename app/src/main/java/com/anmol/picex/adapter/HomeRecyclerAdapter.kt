package com.anmol.picex.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.anmol.picex.R
import com.anmol.picex.activity.MainRegister

class HomeRecyclerAdapter(val context: Context, val nameList: ArrayList<String>, val designationList: ArrayList<String>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>(){
    class HomeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nametxt: TextView = view.findViewById(R.id.personname)
        val desigtxt: TextView = view.findViewById(R.id.designationtxt)
        val llContent:LinearLayout = view.findViewById(R.id.llContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_homepage_single_row, parent, false)

        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val name = nameList[position]
        val designation = designationList[position]
        holder.nametxt.text = name
        holder.desigtxt.text = designation

        holder.llContent.setOnClickListener{
            Toast.makeText(context, "Clicked on ${holder.nametxt.text}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}