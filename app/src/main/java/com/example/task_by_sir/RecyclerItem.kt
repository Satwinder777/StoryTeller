package com.example.task_by_sir

import android.net.Uri
import android.view.View
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.VideoDataCls

//class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//    val imageView: ImageView = itemView.findViewById(R.id.childImage)
//}
class VideoViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(uri: VideoDataCls) {
        VideoItem.setVideoURI(uri.video)
    }

    val VideoItem: VideoView = itemView.findViewById(R.id.videoViewItemAdapter)
}