package com.example.fragments



import android.content.Context
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dataClass.ParentItem

import com.example.task_by_sir.R
import com.google.android.material.card.MaterialCardView


class AdapterData(var list: MutableList<ParentItem>,var OncardClick:AdapterData.cardClick,var onSharebtnClick:AdapterData.onshareClick):RecyclerView.Adapter<AdapterData.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
//        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
//        layoutParams.isFullSpan = childrc2.isFullWidth // Set isFullSpan to true if the item should span the entire width
//        layoutParams.spanIndex = position % spanCount // Set the span index based on the item position
//        layoutParams.spanSize = item.spanSize // Set the span size of the item
//        holder.bind(item)
        holder.apply {

            val parentItem = list[position]


            childrc.layoutManager = LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
            var adapter = ChildAdapter(parentItem.mList)
            childrc.adapter = adapter

            //

            childrc2.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
            var adapter1 =ChildAdapter2(parentItem.list)
            childrc2.adapter =adapter1
            card.setOnClickListener {
                OncardClick.oncardclick(position)
            }
            sharebtn.setOnClickListener {
                onSharebtnClick.shareClick(position,it)

            }
            commentbtn.setOnClickListener {
                onSharebtnClick.shareClick(position,it)

            }
            aboutbtn.setOnClickListener {
                onSharebtnClick.shareClick(position,it)

            }
        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
            var childrc = ItemView.findViewById<RecyclerView>(R.id.childrc)
            var childrc2 = ItemView.findViewById<RecyclerView>(R.id.parentrc1)
            var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)
            var sharebtn = ItemView.findViewById<ImageView>(R.id.sharebtn)
            var commentbtn = ItemView.findViewById<ImageView>(R.id.commentbtn)
            var aboutbtn = ItemView.findViewById<ImageView>(R.id.aboutbtn)




    }
    interface cardClick{
        fun oncardclick(position:Int)
    }
    interface onshareClick{
        fun shareClick(position:Int,view:View)
    }

}

