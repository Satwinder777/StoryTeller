package com.example.task_by_sir

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.AdapterData4

class NotificationActivity : AppCompatActivity(),AdapterData4.cardClick {

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        var recyclerView :RecyclerView = findViewById(R.id.recyclerViewnotifications)
        val list = mutableListOf<String>("sdd","sdd","sdd","sdd","sdd","sdd","sdd","sdd","sdd","sdd",)
        val adapter = AdapterData4(list,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()





        val backbtn = findViewById<ImageView>(R.id.backbtn1)
        backbtn.setOnClickListener {
            this.finish()
        }
        }

    override fun onnotificationclick(position: Int, view: View) {
        view.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.popup, popupMenu.menu)
            popupMenu.show()

        }
    }


}