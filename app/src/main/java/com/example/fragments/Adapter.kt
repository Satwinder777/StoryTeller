package com.example.fragments



import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ParentItem
import com.example.dataClass.VideoDataCls
import com.example.task_by_sir.R
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.card.MaterialCardView


class AdapterData(var list: MutableList<ParentItem>, var list2: MutableList<VideoDataCls>, var OncardClick:AdapterData.cardClick, var onSharebtnClick:AdapterData.onshareClick):
    RecyclerView.Adapter<AdapterData.InerClass>(){
    lateinit var storyDAta:MutableList<Any>



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
        return  InerClass(view )
    }

    override fun getItemCount(): Int {
        var size = list.size
        return size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: InerClass, position: Int) {
        var packageName = this
        var vidDAta = mutableListOf<String>("android.resource://" + packageName + "/" + R.raw.video0,"android.resource://" + packageName + "/" + R.raw.video1,"android.resource://" + packageName + "/" + R.raw.video0)
        var uri2 = Uri.parse(vidDAta[2])
        var uri1 = Uri.parse(vidDAta[1])
        var uri0 = Uri.parse(vidDAta[0])
        storyDAta = mutableListOf(ChildData(R.drawable.girl2),VideoDataCls(uri1),ChildData(R.drawable.girl2),VideoDataCls(uri1),)


//        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
//        layoutParams.isFullSpan = childrc2.isFullWidth // Set isFullSpan to true if the item should span the entire width
//        layoutParams.spanIndex = position % spanCount // Set the span index based on the item position
//        layoutParams.spanSize = item.spanSize // Set the span size of the item

//        holder.bind(item)
        holder.apply {

            val parentItem = list[position]

//            var list2 = mutableListOf<VideoDataCls>(VideoDataCls(uri0))


            childrc.layoutManager = LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
            var adapter = ChildAdapter(storyDAta,null)

            childrc.adapter = adapter
            adapter?.notifyDataSetChanged()

            //

//            childrc2.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
            val layoutManager = FlexboxLayoutManager(itemView.context)
            layoutManager.setFlexDirection(FlexDirection.ROW)
            layoutManager.setJustifyContent(JustifyContent.FLEX_START)
//            context.findViewById(R.id.recyclerview).layoutManager = layoutManager
            childrc2.layoutManager = layoutManager
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

            moreImg.visibility = View.GONE
            cardApproved.visibility = View.GONE
            checkImgItem.visibility= View.GONE
            inspiredcard.visibility = View.VISIBLE
            constraint1.visibility = View.VISIBLE
            commentSection.visibility = View.GONE
            commentRecyclerView.visibility = View.GONE
        }
    }
    class InerClass(ItemView: View):RecyclerView.ViewHolder(ItemView) {
            var childrc = ItemView.findViewById<RecyclerView>(R.id.childrc)
            var childrc2 = ItemView.findViewById<RecyclerView>(R.id.parentrc1)
            var card = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)
            var sharebtn = ItemView.findViewById<ImageView>(R.id.sharebtn)
            var commentbtn = ItemView.findViewById<ImageView>(R.id.commentbtn)
            var aboutbtn = ItemView.findViewById<ImageView>(R.id.aboutbtn)

        //
        val checkImgItem = ItemView.findViewById<ImageView>(R.id.checkImgItem)
        val moreImg = ItemView.findViewById<ImageView>(R.id.moreImg)
        val cardApproved = ItemView.findViewById<MaterialCardView>(R.id.cardApproved)
        val inspiredcard = ItemView.findViewById<MaterialCardView>(R.id.inspiredcard)
        val constraint1 = ItemView.findViewById<ConstraintLayout>(R.id.constraint0)
        val commentSection = ItemView.findViewById<ConstraintLayout>(R.id.commentSection)
        val commentRecyclerView = ItemView.findViewById<RecyclerView>(R.id.commentRecyclerView)




    }
    interface cardClick{
        fun oncardclick(position:Int)
    }
    interface onshareClick{
        fun shareClick(position:Int,view:View)
    }


}

