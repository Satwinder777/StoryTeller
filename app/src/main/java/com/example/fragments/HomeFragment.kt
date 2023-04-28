package com.example.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.PopupWindow
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.ParentItem
import com.example.dataClass.VideoDataCls
import com.example.fragments.StoryFragment.Companion.textList
import com.example.task_by_sir.InspirationActivity
import com.example.task_by_sir.NotificationActivity
import com.example.task_by_sir.R
import com.example.task_by_sir.databinding.FragmentHome4Binding
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment(),AdapterData.cardClick,AdapterData.onshareClick{

    private lateinit var binding:FragmentHome4Binding
    val ParentList = mutableListOf<ParentItem>( )
    val newLIst = mutableListOf<VideoDataCls>( )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHome4Binding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("MissingInflatedId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)

        var pop = view.findViewById<ImageView>(R.id.showpop)
        pop.setOnClickListener {
            var window = PopupWindow(requireContext())
            var view = layoutInflater.inflate(R.layout.main_pop_up,null)
            window.contentView = view
            var popimg = view.findViewById<ImageView>(R.id.popimg)
            popimg.setOnClickListener {
                window.dismiss()



            }

//            window.showAsDropDown(pop)
            window.showAtLocation(view, Gravity.CENTER, 0, 0)

        }

        val recycler = binding.recycler
        addDataToList()
        val adapter = AdapterData(ParentList,newLIst,this,this)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter



        var bell = binding.bell

        bell.setOnClickListener {

            val intent = Intent(requireContext(),NotificationActivity::class.java)

            startActivity(intent)
        }
val updown:ImageView = binding.upDown
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
            ChildData2( "Boring Most",R.color.brown),
            ChildData2( "Intriguing",R.color.blue),
            ChildData2( "Illustious",R.color.sky),
            ChildData2( "Striking Boring",R.color.red),
            ChildData2( "pleasure Reading",R.color.brown),
            ChildData2( "Appealing",R.color.blue),
            ChildData2( "Appealing",R.color.blue),
            ChildData2( "Apaling",R.color.blue),
            ChildData2( "Appeing",R.color.blue),
            ChildData2( "Appealinyh hy uhbuh ug",R.color.blue),
            ChildData2( "Appealing",R.color.blue),

        )


        ParentList.add(ParentItem(childList,childList2,newLIst, textList))
        ParentList.add(ParentItem(childList,childList2,newLIst, textList))
        ParentList.add(ParentItem(childList,childList2,newLIst, textList))
        ParentList.add(ParentItem(childList,childList2,newLIst, textList))
        ParentList.add(ParentItem(childList,childList2,newLIst, textList))
    }
//    var comboList = mutableListOf<Any>(newLIst,childList2)

}