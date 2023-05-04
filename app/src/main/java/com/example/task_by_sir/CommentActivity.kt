package com.example.task_by_sir

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.ChildData
import com.example.dataClass.ChildData2
import com.example.dataClass.CommentItem
import com.example.dataClass.ParentItem
import com.example.fragments.CommentAdapter
import com.example.fragments.StoryFragment
import com.example.task_by_sir.databinding.ActivityCommentBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import java.util.logging.Level
import java.util.logging.Logger

class CommentActivity  : AppCompatActivity(),CommentAdapter.updateData1 {
    private lateinit var binding :ActivityCommentBinding
    private val ParentList = mutableListOf<ParentItem>( )
    private lateinit var list:MutableList<CommentItem>
    private lateinit var adapter:CommentAdapter
    private lateinit var dialog:BottomSheetDialog
    private lateinit var recyclerView:RecyclerView
//    private lateinit var comment:CommentItem
var defaultUser = "satwinder_8182"

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
         dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.comment_more_dialog)
         list = mutableListOf<CommentItem>(CommentItem(defaultUser,"Hellow World"),CommentItem(defaultUser,"hello jatin"))
//        val adapter = StoryCommentAdapter(list)
//        var recyclerView = findViewById<RecyclerView>(R.id.commentRecyclerView)
        recyclerView = findViewById<RecyclerView>(R.id.commentRecyclerViewParent)
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


        ParentList.add(ParentItem(childList,childList2,null, StoryFragment.textList))
        ParentList.add(ParentItem(childList,childList2,null, StoryFragment.textList))
        ParentList.add(ParentItem(childList,childList2,null, StoryFragment.textList))
        ParentList.add(ParentItem(childList,childList2,null, StoryFragment.textList))
        ParentList.add(ParentItem(childList,childList2,null, StoryFragment.textList))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateAdapter(position: Int, item: CommentItem) {
        list.add(item)
        adapter.notifyDataSetChanged()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun openDialog(view: View) {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.comment_more_dialog)
        //opertion
        var share = dialog.findViewById<LinearLayout>(R.id.shareItem)
        var report = dialog.findViewById<LinearLayout>(R.id.reportItem)

        view.setOnClickListener {
            var TAG = "test1"
            dialog.show()
            share?.setOnClickListener { val dialog1 = BottomSheetDialog(this)
                dialog1.setContentView(R.layout.dialogbottom)
                dialog.dismiss()
                dialog1.show()
            }


            var reply = dialog.findViewById<LinearLayout>(R.id.replyItem)
            reply?.setOnClickListener {
                dialog.dismiss()
//                val edit = findViewById<EditText>(R.id.editTextTextPersonName2)
                var edit =  findViewById<EditText>(R.id.editTextTextPersonName2)


                edit.requestFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(edit, InputMethodManager.SHOW_IMPLICIT)



            }

            report?.setOnClickListener {
                dialog.dismiss()
                val dialog = BottomSheetDialog(this)
                dialog.setContentView(R.layout.report_dialog_item)
                dialog.show()

                dialog.window?.apply {
                    setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    setDimAmount(0.72f)
                }
                var spam = dialog.findViewById<TextView>(R.id.spamtxt)

                var scamfraud = dialog.findViewById<TextView>(R.id.scamfraudtxt)
                var falseinfo = dialog.findViewById<TextView>(R.id.falseinfotxt)
                var dontlike = dialog.findViewById<TextView>(R.id.dontliketxt)

                spam!!.requestFocus()

                scamfraud!!.setOnClickListener {

                findView(scamfraud,dialog)

                  }
                spam.setOnClickListener {

                findView(spam,dialog)

                  }
                falseinfo!!.setOnClickListener {

                findView(falseinfo,dialog)

                  }
                dontlike!!.setOnClickListener {

                findView(dontlike,dialog)

                  }


              }

        }
    }

    override fun activeEdit(view: View) {

    }

@SuppressLint("MissingInflatedId", "InflateParams")
fun findView(view: View,bottomSheetDialog: BottomSheetDialog){
var TAG = "satta"

            view.setBackgroundColor(ContextCompat.getColor(this,R.color.blue1))
            bottomSheetDialog.dismiss()
            view.hasFocus()

            var popupWindow = PopupWindow(this)
                var view1 = layoutInflater.inflate(R.layout.report_popup,null)
            window.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.custom_popup_bg))


    popupWindow.setOnDismissListener {
        val layoutParams = window?.attributes
        layoutParams?.alpha = 1f
        window?.attributes = layoutParams
    }

    val layoutParams = window?.attributes
    layoutParams?.alpha = 0.3f
    window?.attributes = layoutParams

    popupWindow.contentView = view1
                var popbtn = view1.findViewById<MaterialButton>(R.id.popbtn1)

    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
            popbtn.setOnClickListener {
                popupWindow.dismiss()
            }
//            window.showAsDropDown(pop)
        }


}