package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.trendzChild
import com.example.task_by_sir.R

class trendFragment : Fragment() {

    var mlist = mutableListOf<trendzChild>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trend2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addDAta()
        val adapter = TrendzAdapter(mlist)
        val rc1:RecyclerView = view.findViewById(R.id.mainTrendzrc)

        rc1.layoutManager = LinearLayoutManager(requireContext())
        rc1.adapter = adapter


        val userCard :CardView = view.findViewById(R.id.usercard)
        val storyCard :CardView = view.findViewById(R.id.storiescard)
        val storytext :TextView = view.findViewById(R.id.inspiredtext)
        val usertext :TextView = view.findViewById(R.id.inspirationtextuser)
        val line3 :TextView = view.findViewById(R.id.line3)
        val line4 :TextView = view.findViewById(R.id.line4)


        userCard.setOnClickListener {
            storyCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
            userCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))

            storytext.setTextColor(ContextCompat.getColor(requireContext(),R.color.blue))
            usertext.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            mlist.clear()
            addDAta()
            val adapter = TrendzAdapter(mlist)
            rc1.adapter = adapter
            line3.visibility = View.VISIBLE
            line4.visibility = View.INVISIBLE
        }
        storyCard.setOnClickListener {
            userCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
            storyCard.setCardBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))

            usertext.setTextColor(ContextCompat.getColor(requireContext(),R.color.blue))
            storytext.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            mlist.clear()
            addDAta()
            val adapter = UserStoriesAdapter(mlist)
//            rc1.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            rc1.adapter = adapter
            line3.visibility = View.INVISIBLE
            line4.visibility = View.VISIBLE
        }
    }


//        inscard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.blue))
//        inspiredcard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.brown))
//        line.visibility = View.VISIBLE
//        line2.visibility = View.INVISIBLE
//        inspiredtext.setTextColor(ContextCompat.getColor(this, R.color.white))
//        inspirationtext.setTextColor(ContextCompat.getColor(this, R.color.white))
//            var list = mutableListOf<String>("satta","gatta","patta","gdjhsg","ghds",)








//fun addlist():MutableList<String>{
//    var newList = mutableListOf<String>("bds","bds","bds","bds","bds","bds","bds","bds","bds","bds",)
//    return newList
//}
    private fun addDAta(){
    mlist.add(trendzChild("Most Inspired"))
    mlist.add(trendzChild("Most Discussed"))
    mlist.add(trendzChild("Most Instresting"))
    mlist.add(trendzChild("Most Boring"))
    mlist.add(trendzChild("Most Shared"))
    }
}