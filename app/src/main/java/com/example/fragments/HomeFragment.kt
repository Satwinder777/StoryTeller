package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.ParentItem
import com.example.task_by_sir.InspirationActivity
import com.example.task_by_sir.NotificationActivity
import com.example.task_by_sir.R
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment(),AdapterData.cardClick,AdapterData.onshareClick{
    val ParentList = mutableListOf<ParentItem>( )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        addDataToList()
        val adapter = AdapterData(ParentList,this,this)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter



        var bell = view.findViewById<ImageView>(R.id.bell)

        bell.setOnClickListener {

            val intent = Intent(requireContext(),NotificationActivity::class.java)

            startActivity(intent)
        }
val updown:ImageView = view.findViewById(R.id.upDown)
        updown.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(requireContext(),updown)
            popupMenu.menuInflater.inflate(R.menu.menu1, popupMenu.menu)
            popupMenu.show()

        }
    }

    override fun oncardclick(position: Int) {
         val intent = Intent(requireContext(),InspirationActivity::class.java)
        startActivity(intent)
    }

    override fun shareClick(position: Int,view:View) {
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.dialogbottom)
        view.setOnClickListener { dialog.show() }

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
            ChildData2( "Boring",R.color.brown),
            ChildData2( "Intriguing",R.color.blue),
            ChildData2( "Illustious",R.color.sky),
            ChildData2( "Striking",R.color.red),
            ChildData2( "pleasure Reading",R.color.brown),
            ChildData2( "Appealing",R.color.blue),

        )


        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
        ParentList.add(ParentItem(childList,childList2))
    }
}