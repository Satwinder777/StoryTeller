package com.example.task_by_sir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.task_by_sir.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding  :ActivityMainBinding
    lateinit var navHostFragment : NavHostFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navHostFragment = supportFragmentManager.findFragmentById(R.id.NavHostFragment1) as NavHostFragment

         var navController = navHostFragment.navController

        val bottomNavigationView = binding.bNView
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        object {
            var view = binding.root
        }
    }
    fun pr(){

//        fr.navController.navigate(R.id.expFragment)
//        val NavHostFragment = NavHostFragment.findNavController(fr!!).navigate(R.id.expFragment)
    }

    }


