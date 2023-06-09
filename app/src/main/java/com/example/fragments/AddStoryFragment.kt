package com.example.fragments

import android.annotation.SuppressLint
import android.app.FragmentManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.task_by_sir.AddStory
import com.example.task_by_sir.R
import com.example.task_by_sir.SelectOneActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

//class AddStoryFragment : Fragment(){
class AddStoryFragment : Fragment() {
//class AddStoryFragment : Fragment() ,AddStory.onPopupOkCkick{


var navController = NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_story,container, false)
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val card1 = view.findViewById<CardView>(R.id.addStoryCard1)
        val card2 = view.findViewById<CardView>(R.id.addStoryCard2)
        val card3 = view.findViewById<CardView>(R.id.addStoryCard3)
        val card4 = view.findViewById<CardView>(R.id.addStoryCard4)
        val card5 = view.findViewById<CardView>(R.id.addStoryCard5)
        val card6 = view.findViewById<CardView>(R.id.addStoryCard6)
        val card7 = view.findViewById<CardView>(R.id.addStoryCard7)
        val card8 = view.findViewById<CardView>(R.id.addStoryCard8)


        onClick(card1)
        onClick(card2)
        onClick(card3)
        onClick(card4)
        onClick(card5)
        onClick(card6)
        onClick(card7)
        onClick1(card8)

//        AddStory(this)


    }

    @SuppressLint("ResourceType")
    private fun onClick(view:View ) {

        view.setOnClickListener {
            val intent = Intent(requireContext(),SelectOneActivity::class.java)
            startActivity(intent)

        }

    }
    private fun onClick1(view:View ) {

        view.setOnClickListener {
            val intent = Intent(requireContext(),SelectOneActivity::class.java)
            startActivity(intent)

        }

    }



    fun onButtonClicked(view:View) {
        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.expFragment)

    }
}