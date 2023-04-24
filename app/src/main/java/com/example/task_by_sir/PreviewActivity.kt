package com.example.task_by_sir

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.viewpager.widget.ViewPager
import com.example.fragments.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class PreviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)


        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this, supportFragmentManager, lifecycle)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}

