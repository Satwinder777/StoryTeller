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
import com.example.dataClass.CommentItem

import com.example.task_by_sir.R
import com.google.android.material.card.MaterialCardView


  class StoryCommentAdapter(var list: MutableList<CommentItem> ):RecyclerView.Adapter<StoryCommentAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_adapter_item,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
holder.apply {

    commentCaption.text = list[position].caption
    commentuserName.text = list[position].username

}
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
//        var UserImg = ItemView.findViewById<ImageView>(R.id.bNView)
//        var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)

        var commentCaption = ItemView.findViewById<TextView>(R.id.commentCaption)
        var commentuserName = ItemView.findViewById<TextView>(R.id.commentuserName)

    }
    interface cardClick{
        fun oncardclick(position:Int)
    }

}

