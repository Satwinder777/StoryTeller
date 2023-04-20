package com.example.task_by_sir

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.noti2Adapter

class notifi2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifi2)

        val recyclerView:RecyclerView = findViewById(R.id.notirecycler)
        val list = mutableListOf<String>("Pause All","Stories","Comment","Inspired",)
        val adapter = noti2Adapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter =adapter

        val backbtn = findViewById<ImageView>(R.id.backbtn3)
        backbtn.setOnClickListener {
            this.finish()
        }
    }
}