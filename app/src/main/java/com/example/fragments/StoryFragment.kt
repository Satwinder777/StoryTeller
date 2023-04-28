package com.example.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.ParentItem
import com.example.dataClass.VideoDataCls
import com.example.task_by_sir.AddStory
import com.example.task_by_sir.CommentActivity
import com.example.task_by_sir.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoryFragment : Fragment(),StoryAdapter.onshareClick,StoryAdapter.cardClick,StoryAdapter.onCommentClick {
    val ParentList = mutableListOf<ParentItem>( )
    lateinit var adapter: StoryAdapter


companion object{
    var textList = mutableListOf<String>("title is null","gabbar is back","satta sher gill")

}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.storyrc)
        addDataToList()
         var adapter = StoryAdapter(requireContext(),ParentList,this,this,this)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter



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
            ChildData2( "Appealing",R.color.blue),

            )



        ParentList.add(ParentItem(childList,childList2,null, textList))
        ParentList.add(ParentItem(childList,childList2,null, textList))
        ParentList.add(ParentItem(childList,childList2,null, textList))
        ParentList.add(ParentItem(childList,childList2,null, textList))
        ParentList.add(ParentItem(childList,childList2,null, textList))
    }

    override fun shareClick(position: Int, view: View) {
        TODO("Not yet implemented")
    }

    override fun oncardclick(position: Int) {

    }

    override fun ccommentClick(position: Int, view: View) {
        val intent  = Intent(this.requireContext(),CommentActivity::class.java)
        startActivity(intent)
    }

//    override fun data(arrayList: ArrayList<String>) {
//        var totalSize = arrayList.size
////        when(totalSize){
////
////            // If the size is divisible by 2 only
////            in 1..Int.MAX_VALUE step 2 -> println("Size is divisible by 2   :${arrayList.}")
////            // If the size is divisible by 3 only
////            in 1..Int.MAX_VALUE step 3 -> println("Size is divisible by 3")
////            // If the size is not divisible by 2 or 3
////            else -> println("Size is not divisible by 2 or 3")
////        }
//
//            ///comment data/////
//

//    }

    interface getData{



        companion object{

            @SuppressLint("NotifyDataSetChanged")
            fun data(arrayList: ArrayList<String>) {
                var data =arrayList.size
                var TAG ="testnew"
                textList = arrayList

//                for (  i in 0 until arrayList.size ) {
////                  log
//                    var NetIndex = i
//
//                    if (NetIndex / 3 == 1) {
//                        Log.e(TAG, "data: ${arrayList[NetIndex]}  got 1 ",)
//                    } else if (NetIndex / 3 == 2) {
//                        Log.e(TAG, "data: ${arrayList[NetIndex]}  got 2  ",)
//
//                    } else {
//                        Log.e(TAG, "data: ${arrayList[NetIndex]} got 0",)
//
//                    }
//                    Log.e(TAG, "data: ////////////////////  curent posinter :$i", )
//                }

                }
            }

        }


        @SuppressLint("NotifyDataSetChanged")
        fun t11(){
            adapter.notifyDataSetChanged()

        }



}