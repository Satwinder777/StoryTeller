package com.example.fragments



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dataClass.trendzChild

import com.example.task_by_sir.R


class TrendzAdapter(var list: MutableList<trendzChild>  ):RecyclerView.Adapter<TrendzAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item9,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.apply {


            text.text = list[position].classItem
        recyclerView.layoutManager = LinearLayoutManager(itemView.context,RecyclerView.HORIZONTAL,false)
            val adapter = trendzChildAdapter(list)
            recyclerView.adapter = adapter


        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
//        var UserImg = ItemView.findViewById<ImageView>(R.id.bNView)
//        var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)
        var recyclerView = ItemView.findViewById<RecyclerView>(R.id.trend1)
        var text = ItemView.findViewById<TextView>(R.id.trendMainitemtxt)



    }
    interface cardClick{
        fun onnotificationclick(position:Int,view:View)
    }

}

