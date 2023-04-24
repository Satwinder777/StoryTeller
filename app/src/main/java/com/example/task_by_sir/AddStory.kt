package com.example.task_by_sir

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.addStoryItem
import com.example.fragments.AddStoryFragment
import com.example.fragments.addStory.AddStoryActivityStoryItem
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso
import java.util.TimerTask

class AddStory : AppCompatActivity() {
//class AddStory: AppCompatActivity() {
//class AddStory(var onOk:onPopupOkCkick) : AppCompatActivity(){



    private lateinit var list: MutableList<addStoryItem>
    lateinit var image: ImageView
    lateinit var adapter: AddStoryActivityStoryItem




    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addstory)

        list = mutableListOf<addStoryItem>()
        adapter = AddStoryActivityStoryItem(list)



        getUriC("girl2")
        getUriC("girl12")

        val storyRecycler = findViewById<RecyclerView>(R.id.addStoryRecycler)


        storyRecycler.adapter = adapter
        adapter.notifyDataSetChanged()


        val btn = findViewById<MaterialButton>(R.id.button)
        btn.setOnClickListener {



            var window = PopupWindow(this)
            var view = layoutInflater.inflate(R.layout.main_pop_up, null)
            window.contentView = view
            var popbtn = view.findViewById<MaterialButton>(R.id.popbtn)
            popbtn.setOnClickListener {
                window.dismiss()
//                var view:View = findViewById(R.id.container)


//                var b = Bundle()
//
//                var a = supportFragmentManager.findFragmentById(R.id.favFragment)


//                mainActivity.doTask()

//                var nav = AddStoryFragment()
//                nav.nav()
//                Navigation.findNavController(view).navigate(this,R.id.expFragment)
//                Navigation.findNavController(view).navigate(R.id.expFragment)
//                var navController:NavController ?= findNavController(R.id.container)
//                navController?.navigateUp()
//                var fragment : Unit = Navigation.findNavController(navController as View).navigate(R.id.action_favFragment_to_expFragment)
//                NavHostFragment.findNavController(v1 as Fragment ).navigate(R.id.action_favFragment_to_expFragment)

             try {
//                 val intent =Intent(this,AddStoryFragment::class.java)
//                 startActivity(intent)

//                 supportFragmentManager.findFragmentById(R.id.expFragment)?.findNavController()?.navigate(R.id.action_favFragment_to_expFragment)
//                 AddStoryFragment().greatTask()
//                 var fragment = AddStoryFragment().navController
//                 NavHostFragment.findNavController(fragment).navigate(R.id.action_favFragment_to_expFragment)




             }
             catch (e:java.lang.Exception){
                 Log.e("satta", "onCreate: ${e.message}", )
             }
            }

            window.showAtLocation(view, Gravity.CENTER, 0, 0)


        }

        //initial lize camera
        val camera = findViewById<ImageView>(R.id.addStoryCamera)

        camera.setOnClickListener {
            ImagePicker.with(this)
                .galleryOnly()    //User can only select image from Gallery
                .start()    //Default Request Code is ImagePicker.REQUEST_CODE
        }


    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

//                mProfileUri = fileUri
//                imgProfile.setImageURI(fileUri)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            image = ImageView(this)


//            var a = 100
//            a++
//
//            val resId = resources.getIdentifier("my_image$a", "drawable", packageName)
//            val imageUri = Uri.parse("android.resource://$packageName/$resId")


            Picasso.get()
                .load(uri)
                .into(image);
            list.add(addStoryItem(uri))
            adapter.notifyDataSetChanged()


        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun getUriC(name: String) {

        val resId = resources.getIdentifier(name, "drawable", packageName)
        val imageUri = Uri.parse("android.resource://$packageName/$resId")
//        val imageUri = Uri.fromFile(imageFile)
        list.add(addStoryItem(imageUri))
        adapter.notifyDataSetChanged()
        Log.e("check11", "getUriC: $imageUri",)
    }





// interface intraFace{
//     fun desiTask(view: View)
// }


    }




