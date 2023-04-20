package com.example.fragments



import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

import com.example.task_by_sir.R
import com.google.android.material.card.MaterialCardView


class userItemAdapter(var list: MutableList<String>,var onitemClick:onClick ):RecyclerView.Adapter<userItemAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myprofileitem,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.apply {

//            var like:Boolean = false
//            itemView.setOnClickListener { OncardClick.onnotificationclick(position,itemView) }

                txt.text = list[position]

            itemView.setOnClickListener { onitemClick.onnotificationclick(position,itemView) }

        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
//        var UserImg = ItemView.findViewById<ImageView>(R.id.bNView)
//        var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)
        var txt = ItemView.findViewById<TextView>(R.id.userItemtxt)



    }
    interface onClick{
        fun onnotificationclick(position:Int,view:View)
    }

}

