package com.example.task_by_sir

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.VideoDataCls

//class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//    val imageView: ImageView = itemView.findViewById(R.id.childImage)
//}
class VideoViewHolder(view: View): RecyclerView.ViewHolder(view){
    var TAG = "test123"




    fun bind(uri: VideoDataCls) {
            VideoItem.setVideoURI(uri.video)
        VideoItem.setOnErrorListener { mp, what, extra ->
            Log.e(TAG, "bind: Error in VideoViewHolder ", )
            true 
        }
    }
    val VideoItem: VideoView = itemView.findViewById(R.id.videoViewItemAdapter)
}