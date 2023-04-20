package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.ParentItem
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
        val adapter = StoryAdapter(requireContext(),ParentList,this,this,this)
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


        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
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

}