package com.example.fragments






import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dataClass.ParentItem
import com.example.task_by_sir.PreviewActivity
import com.example.task_by_sir.PreviewStory

import com.example.task_by_sir.R


class StoryAdapter(var context: Context,var list: MutableList<ParentItem>,var OncardClick:StoryAdapter.cardClick,var onSharebtnClick:StoryAdapter.onshareClick,var comentClicks:onCommentClick ):RecyclerView.Adapter<StoryAdapter.InerClass>(),storychild21Adapter.onClickImgVid {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
        return  InerClass(context,view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return 1
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
            var adapter = storychild21Adapter(parentItem.mList,this@StoryAdapter)
            childrc.adapter = adapter

            //

            childrc2.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
            var adapter1 =StoryChild2Adapter(parentItem.list)
            childrc2.adapter =adapter1
//            card.setOnClickListener {
//                OncardClick.oncardclick(position)
//            }
            sharebtn.setOnClickListener {
                onSharebtnClick.shareClick(position,it)

            }
            commentbtn.setOnClickListener {
                comentClicks.ccommentClick(position,it)

            }
            aboutbtn.setOnClickListener {
                onSharebtnClick.shareClick(position,it)

            }
            constraint1.visibility = View.GONE
            parentCommentSection.visibility = View.GONE
            commentRecyclerView.visibility = View.GONE


        }
    }
    class InerClass(var context: Context,ItemView: View):RecyclerView.ViewHolder(ItemView) {
        var childrc = ItemView.findViewById<RecyclerView>(R.id.childrc)
        var childrc2 = ItemView.findViewById<RecyclerView>(R.id.parentrc1)
        var sharebtn = ItemView.findViewById<ImageView>(R.id.sharebtn)
        var commentbtn = ItemView.findViewById<ImageView>(R.id.commentbtn)
        var aboutbtn = ItemView.findViewById<ImageView>(R.id.aboutbtn)

        var constraint1 = ItemView.findViewById<ConstraintLayout>(R.id.constraint0)
        val parentCommentSection = ItemView.findViewById<ConstraintLayout>(R.id.commentSection)
        val commentRecyclerView = ItemView.findViewById<RecyclerView>(R.id.commentRecyclerView)




    }
    interface cardClick{
        fun oncardclick(position:Int)
    }
    interface onshareClick{
        fun shareClick(position:Int,view:View)
    }
    interface onCommentClick{
        fun ccommentClick(position:Int,view:View)
    }

    override fun openVide(view: View, position: Int) {
        var intent = Intent(this.context,PreviewStory::class.java)
        this.context.startActivity(intent)

    }
//    override fun openVide(view: View, position: Int) {
//        var intent = Intent(this.context,PreviewFragment::class.java)
//        this.context.startActivity(intent)
//
//    }



}

