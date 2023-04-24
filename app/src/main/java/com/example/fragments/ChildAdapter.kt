package com.example.fragments



import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.*

import com.example.task_by_sir.R
import com.example.task_by_sir.VideoViewHolder


class ChildAdapter(var list: MutableList<Any>,var passData1:passData?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_IMAGE = 0
        const val VIEW_TYPE_VIDEO = 1

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.e("test", "getItemViewType:  $list " )

      return when (viewType) {
            VIEW_TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item7, parent, false)
                InerClass(view)
            }
            VIEW_TYPE_VIDEO -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.video_view_item, parent, false)
                VideoViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

//        when (holder) {
//            is InerClass -> {
////                 Bind the text view data
//                holder.apply {
//                    list2[position].image?.let { childImage.setImageResource(it) }
//
//                }
//            }
//            is VideoViewHolder -> {
//                holder.apply {
//                    VideoItem.setVideoURI(list3[position].video)
//
//                }
//            }
//            else -> {
//                throw IllegalArgumentException("Invalid Argument")
//            }
//        }
        val item = list[position]
        val item1 = list[position]
        when (holder) {
             is InerClass -> {
                val image = item as ChildData
                (holder).bind(image)

                 passData1?.imageDAta(image,position,holder.itemView)
            }
           is VideoViewHolder -> {
                val video = item as VideoDataCls
                (holder).bind(video)
               passData1?.videoDAta(video,position,holder.itemView)
            }
            else ->{
                throw IllegalArgumentException("Errorr Occur binding")
            }
        }

    }

    override fun getItemCount(): Int {
        var size = list.size
        return size


    }

    @SuppressLint("SuspiciousIndentation")
    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        Log.e("test", "getItemViewType:  $list ", )

        return when (list[position]) {
            is ChildData  -> VIEW_TYPE_IMAGE
            is VideoDataCls -> VIEW_TYPE_VIDEO
            else ->  throw IllegalArgumentException("got error")



            }




    }

        class InerClass(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            var childImage = ItemView.findViewById<ImageView>(R.id.childImage)

            fun bind(img: ChildData) {
                img.image?.let { childImage.setImageResource(it) }
            }


        }


interface passData{
     fun imageDAta(ChildData: ChildData, position: Int, itemView: View)
     fun videoDAta(ChildData: VideoDataCls, position: Int, itemView: View)
}

}
