package com.example.fragments






import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData

import com.example.task_by_sir.R


class storychild21Adapter(var list: MutableList<ChildData>,var onClickImgVid1:onClickImgVid):RecyclerView.Adapter<storychild21Adapter.InerClass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.storychild2item,parent,false)
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
            childImage.setOnClickListener {
                onClickImgVid1.openVide(it)
            }

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
    interface onClickImgVid{
        fun openVide(view: View)
    }

}

