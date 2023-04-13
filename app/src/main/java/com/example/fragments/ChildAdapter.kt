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
import com.example.dataClass.ChildData

import com.example.task_by_sir.R
import com.google.android.material.card.MaterialCardView


class ChildAdapter(var list: MutableList<ChildData>):RecyclerView.Adapter<ChildAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item7,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.apply {

//            var like:Boolean = false
//            card.setOnClickListener { OncardClick.oncardclick(position) }
//            sharebtn.setOnClickListener { onSharebtnClick.shareClick(position, sharebtn) }
        childImage.setImageResource(list[position].img)

        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
//        var UserImg = ItemView.findViewById<ImageView>(R.id.bNView)
//        var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)
        var childImage = ItemView.findViewById<ImageView>(R.id.childImage)



    }
    interface cardClick{
        fun oncardclick(position:Int)
    }
    interface onshareClick{
        fun shareClick(position:Int,view:View)
    }

}

