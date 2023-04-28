package com.example.fragments






import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dataClass.CommentItem
import com.example.dataClass.ParentItem

import com.example.task_by_sir.R


class CommentAdapter(var context: Context,var list: MutableList<ParentItem>, var list2: MutableList<CommentItem>,var updateData: updateData1):RecyclerView.Adapter<CommentAdapter.InerClass>(),storychild21Adapter.onClickImgVid {
//class CommentAdapter(var list: MutableList<ParentItem>, var list2: MutableList<CommentItem>, var OncardClick:CommentAdapter.cardClick, var onSharebtnClick:CommentAdapter.onshareClick):RecyclerView.Adapter<CommentAdapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
        return  InerClass(view ,context)
    }

    override fun getItemCount(): Int {
        var size = list.size
        return 1
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: InerClass, position: Int) {
//        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
//        layoutParams.isFullSpan = childrc2.isFullWidth // Set isFullSpan to true if the item should span the entire width
//        layoutParams.spanIndex = position % spanCount // Set the span index based on the item position
//        layoutParams.spanSize = item.spanSize // Set the span size of the item
        var defaultUser = "Satwinder_8182"
//        holder.bind(item)

        holder.apply {

            val parentItem = list[position]




            //

            chipItemRecyclerView.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
            var adapter1 =StoryChild2Adapter(parentItem.list)
            chipItemRecyclerView.adapter =adapter1

            storyDataRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
            var adapter = storychild21Adapter(parentItem.mList,this@CommentAdapter)
            storyDataRecyclerView.adapter = adapter


            commentRecyclerView.layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.VERTICAL,false)
            var commentAdapter = StoryCommentAdapter(list2)
            commentRecyclerView.adapter = commentAdapter

            constraint1.visibility = View.GONE

            iconLinearL.visibility = View.GONE
            editComment
            addComment.setOnClickListener {
               var item = CommentItem(defaultUser,editComment.text.toString())
                updateData.updateAdapter(position,item)
                commentAdapter.notifyDataSetChanged()

                editComment.text.clear()
                updateData.activeEdit(it)



            }
             moreImg.setOnClickListener {
                 updateData.openDialog(it)
             }
            lineHorizontal.visibility = View.GONE
        }
    }
    class InerClass(ItemView: View,var context: Context):RecyclerView.ViewHolder(ItemView) {
        var storyDataRecyclerView = ItemView.findViewById<RecyclerView>(R.id.childrc)
        var chipItemRecyclerView = ItemView.findViewById<RecyclerView>(R.id.parentrc1)
        var commentRecyclerView = ItemView.findViewById<RecyclerView>(R.id.commentRecyclerView)
        var sharebtn = ItemView.findViewById<ImageView>(R.id.sharebtn)
        var commentbtn = ItemView.findViewById<ImageView>(R.id.commentbtn)
        var aboutbtn = ItemView.findViewById<ImageView>(R.id.aboutbtn)
        var moreImg = ItemView.findViewById<ImageView>(R.id.moreImg)

        var constraint1 = ItemView.findViewById<ConstraintLayout>(R.id.constraint0)
        var iconLinearL = ItemView.findViewById<LinearLayout>(R.id.linearLayoutIconCSA)

        val addComment = ItemView.findViewById<ImageView>(R.id.addComment)
        var editComment = ItemView.findViewById<EditText>(R.id.editTextTextPersonName2)
        var lineHorizontal  = ItemView.findViewById<View>(R.id.lineHorizontal)





    }

    interface updateData1{
        fun updateAdapter(position: Int,item: CommentItem)
        fun openDialog(view: View)
        fun activeEdit(view: View)
    }

    override fun openVide(view: View, position: Int) {
        val intent = Intent(this.context,PreviewFragment::class.java)
        this.context.startActivity(intent)
    }


}

