package com.example.task_by_sir

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
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
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton

class CommentActivity  : AppCompatActivity(),CommentAdapter.updateData1 {
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
        setContentView(R.layout.activity_comment)
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

                var spam = dialog.findViewById<TextView>(R.id.spamtxt)
                var scamfraud = dialog.findViewById<TextView>(R.id.scamfraudtxt)
                var falseinfo = dialog.findViewById<TextView>(R.id.falseinfotxt)
                var dontlike = dialog.findViewById<TextView>(R.id.dontliketxt)

                findView(spam)
                findView(scamfraud)
                findView(falseinfo)
                findView(dontlike)
            }

        }
    }

    override fun activeEdit(view: View) {

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
@SuppressLint("MissingInflatedId")
fun findView(view: View?){

    view?.setOnClickListener {
        view?.setBackgroundColor(ContextCompat.getColor(this,R.color.blue1))
        var pop = view.findViewById<ImageView>(R.id.showpop)
        pop.setOnClickListener {
            var window = PopupWindow(this)
            var view = layoutInflater.inflate(R.layout.report_popup,null)
            window.contentView = view
            var popbtn = view.findViewById<MaterialButton>(R.id.popbtn1)
            popbtn.setOnClickListener {
                window.dismiss()



            }

//            window.showAsDropDown(pop)
            window.showAtLocation(view, Gravity.CENTER, 0, 0)

        }
    }
    view?.setBackgroundColor(ContextCompat.getColor(this,R.color.white))





//    view.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
//        view.setOnClickListener {
//
//        }

    }
}