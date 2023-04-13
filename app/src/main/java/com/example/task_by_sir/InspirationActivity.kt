package com.example.task_by_sir

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.AdapterData2
import com.example.fragments.AdapterData3
import com.google.android.material.card.MaterialCardView

class InspirationActivity : AppCompatActivity() {
    var a =true
    @SuppressLint("MissingInflatedId", "ResourceAsColor", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspiration)


        var recyclerView :RecyclerView = findViewById(R.id.inspirationrecycler)
        var list = mutableListOf<String>("satta","gatta","patta","gdjhsg","ghds",)

        val adapter = AdapterData2(list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val myList= mutableListOf<String>("sfd","sfd","sfd","sfd","sfd","sfd","sfd","sfd",)

        val inscard:CardView = findViewById(R.id.inspirationcard)
        val inspiredtext:TextView = findViewById(R.id.inspiredtext)
        val inspirationtext:TextView = findViewById(R.id.inspirationtext)
        val line:TextView = findViewById(R.id.line)
        val line2:TextView = findViewById(R.id.line2)
        line2.visibility = View.INVISIBLE
        val inspiredcard: MaterialCardView =findViewById(R.id.Inspiredcard)
        inspiredcard.setOnClickListener {
            inspiredcard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            inscard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.brown))

            inspiredtext.setTextColor(ContextCompat.getColor(this, R.color.white))
            inspirationtext.setTextColor(ContextCompat.getColor(this, R.color.white))
            line.visibility = View.INVISIBLE
            line2.visibility = View.VISIBLE


            adapter.notifyDataSetChanged()

            val adapter = AdapterData3(addlist())

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        val backbtn = findViewById<ImageView>(R.id.backbtn2)
        backbtn.setOnClickListener {
            this.finish()
        }
        inscard.setOnClickListener {
            myList.clear()
            adapter.notifyDataSetChanged()
            inscard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            inspiredcard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.brown))
            line.visibility = View.VISIBLE
            line2.visibility = View.INVISIBLE
            inspiredtext.setTextColor(ContextCompat.getColor(this, R.color.white))
            inspirationtext.setTextColor(ContextCompat.getColor(this, R.color.white))
//            var list = mutableListOf<String>("satta","gatta","patta","gdjhsg","ghds",)

            val adapter = AdapterData2(addlist())



            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }


    }
    fun addlist():MutableList<String>{
        var newList = mutableListOf<String>("bds","bds","bds","bds","bds","bds","bds","bds","bds","bds",)
        return newList
    }
}