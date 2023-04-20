package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_by_sir.EditProfileActivity
import com.example.task_by_sir.InspirationActivity
import com.example.task_by_sir.R
import com.example.task_by_sir.notifi2Activity
import com.google.android.material.card.MaterialCardView

class UserFragment : Fragment(), userItemAdapter.onClick{


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val insCard :MaterialCardView = view.findViewById(R.id.myprofilecard)
        val inspCard :MaterialCardView = view.findViewById(R.id.inspiredCard)
        insCard.setOnClickListener {
            openActivity()
        }
        inspCard.setOnClickListener {
            openActivity()
        }


        val recycler :RecyclerView = view.findViewById(R.id.userRecycler)
        val list = mutableListOf<String>("Edit Profile","Notification","Demo Link","Setting","Log out Account ","Delete Account")
        val adapter = userItemAdapter(list,this)
        recycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recycler.adapter = adapter
    }

    override fun onnotificationclick(position: Int,view: View) {

            if (position==0){
                val intent = Intent(requireContext(),EditProfileActivity::class.java)
                startActivity(intent)
            }
        if (position==1){
                val intent = Intent(requireContext(),notifi2Activity::class.java)
                startActivity(intent)
            }


    }
    private fun openActivity(){
        val intent = Intent(requireContext(),InspirationActivity::class.java)
        startActivity(intent)
    }


}