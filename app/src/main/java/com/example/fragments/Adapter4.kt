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


class AdapterData4(var list: MutableList<String> ,var OncardClick:AdapterData4.cardClick):RecyclerView.Adapter<AdapterData4.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item4,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.apply {

//            var like:Boolean = false
            itemView.setOnClickListener { OncardClick.onnotificationclick(position,itemView) }


        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
//        var UserImg = ItemView.findViewById<ImageView>(R.id.bNView)
//        var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)



    }
    interface cardClick{
        fun onnotificationclick(position:Int,view:View)
    }

}

