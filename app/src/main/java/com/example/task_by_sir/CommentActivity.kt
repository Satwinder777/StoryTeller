package com.example.task_by_sir

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.CommentItem
import com.example.dataClass.ParentItem
import com.example.fragments.AdapterData
import com.example.fragments.CommentAdapter
import com.example.fragments.StoryCommentAdapter

class CommentActivity : AppCompatActivity(),CommentAdapter.updateData1 {
    private val ParentList = mutableListOf<ParentItem>( )
    private lateinit var list:MutableList<CommentItem>
    private lateinit var adapter:CommentAdapter
//    private lateinit var comment:CommentItem
var defaultUser = "satwinder_8182"

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

         list = mutableListOf<CommentItem>(CommentItem(defaultUser,"Hellow World"),CommentItem(defaultUser,"hello jatin"))
//        val adapter = StoryCommentAdapter(list)
//        var recyclerView = findViewById<RecyclerView>(R.id.commentRecyclerView)
        var recyclerView = findViewById<RecyclerView>(R.id.commentRecyclerViewParent)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        addDataToList()
       adapter = CommentAdapter(this,ParentList,list,this)
        recyclerView.adapter = adapter
        var editComment = findViewById<EditText>(R.id.editTextTextPersonName2)
        var backbtn = findViewById<ImageView>(R.id.backBtnCommentActivity)
        backbtn.setOnClickListener {
            onBackPressed()
        }








    }

    private fun addDataToList(){
        var childList = mutableListOf<ChildData>(
            ChildData(R.drawable.img1),
            ChildData(R.drawable.girl2),
            ChildData(R.drawable.img3),
            ChildData(R.drawable.img1),
            ChildData(R.drawable.girl2),
            ChildData(R.drawable.img3),

            )
        var childList2 = mutableListOf<ChildData2>(
            ChildData2("Appealing",R.color.blue ),
            ChildData2( "Boring",R.color.red),
            ChildData2( "Interesting",R.color.sky),
            ChildData2( "Boring Most",R.color.brown),
            ChildData2( "Intriguing",R.color.blue),
            ChildData2( "Illustious",R.color.sky),
            ChildData2( "Striking Boring",R.color.red),
            ChildData2( "pleasure Reading",R.color.brown),


            )


        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateAdapter(position: Int, item: CommentItem) {
        list.add(item)
        adapter.notifyDataSetChanged()
    }


//    override fun oncardclick(position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun shareClick(position: Int, view: View) {
//        TODO("Not yet implemented")
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    override fun addComment(view: View,text: EditText) {
//
//        var comment = CommentItem(defaultUser,text.text.toString())
//        list.add(comment)
//        adapter.notifyDataSetChanged()
//    }
}