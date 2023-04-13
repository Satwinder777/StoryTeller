package com.example.fragments



import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.trendzChild

import com.example.task_by_sir.R
import com.google.android.material.card.MaterialCardView


class trendzChildAdapter(var list: MutableList<trendzChild>):RecyclerView.Adapter<trendzChildAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item5,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: InerClass, position: Int) {
        var cp =list[position]
        holder.apply {


//        textView.text = cp.text
//            card.setCardBackgroundColor(ContextCompat.getColor(itemView.context, cp.clr))
        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {

//        var card = ItemView.findViewById<CardView>(R.id.cardimp)
//        var textView = ItemView.findViewById<TextView>(R.id.textimp)




    }
    interface cardClick{
        fun oncardclick(position:Int)
    }
    interface onshareClick{
        fun shareClick(position:Int,view:View)
    }

}

