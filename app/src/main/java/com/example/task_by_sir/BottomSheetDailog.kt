package com.example.task_by_sir

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView

class BottomSheetDailog : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cameradialogsheet)


        var dialohCameraText = findViewById<TextView>(R.id.dialogCameraText)
        var dialohVideoText = findViewById<TextView>(R.id.dialogVideoText)
        var dialohgifText = findViewById<TextView>(R.id.dialogGifText)
        var lineardialog = findViewById<LinearLayout>(R.id.lineardialog)
        lineardialog.setOnClickListener {
            val intent = Intent(this,AddStory::class.java)
            startActivity(intent)
            Log.e("check", "onCreate: click1", )
        }


    }
}