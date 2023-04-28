package com.example.task_by_sir

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dataClass.addStoryItem
import com.example.fragments.AddStoryFragment
import com.example.fragments.StoryFragment
import com.example.fragments.addStory.AddStoryActivityStoryItem
import com.example.task_by_sir.databinding.AddstoryBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso
import kotlin.math.log

class AddStory  : AppCompatActivity() {
    private lateinit var binding: AddstoryBinding
    lateinit var titleEdit: EditText
    lateinit var descEdit: EditText
    lateinit var keywordEdit: EditText


//class AddStory: AppCompatActivity() {
//class AddStory(var onOk:onPopupOkCkick) : AppCompatActivity(){


    private lateinit var list: MutableList<addStoryItem>
    lateinit var image: ImageView
    lateinit var adapter: AddStoryActivityStoryItem


    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddstoryBinding.inflate(layoutInflater)
            setContentView(binding.root)


        list = mutableListOf<addStoryItem>()
        adapter = AddStoryActivityStoryItem(list)
        titleEdit = binding.tittleEditText
        descEdit = binding.tittleEditText
        keywordEdit = binding.keywordEditText



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

                try {
                    onButtonClicked(it)


                } catch (e: java.lang.Exception) {
                    Log.e("satta", "onCreate: ${e.message}")
                }
                tast2(it)
                SelectOneActivity().tast2()
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
        Log.e("check11", "getUriC: $imageUri")
    }


// interface intraFace{
//     fun desiTask(view: View)
// }

    private fun sendDAta() {
//        val bundle = Bundle()
        var title = titleEdit.text.toString()
        var desc = descEdit.text.toString()
        var keyword = keywordEdit.text.toString()
        var array = arrayListOf<String>(title, desc, keyword)
//        bundle.getString("title",title)
        StoryFragment.getData.data(array)


    }

    fun onButtonClicked(view: View) {
//        val navController = Navigation.findNavController(view)
//        navController.navigate(R.id.expFragment)
        view.setOnClickListener {
//            supportFragmentManager.findFragmentById(R.id.container)?.findNavController()
//                ?.navigate(R.id.expFragment)

//            supportFragmentManager.findFragmentById(R.id.homeFragment)?.findNavController()?.navigate(R.id.homeFragment)

        }

    }

    @SuppressLint("ResourceType")
    private fun tast2(view: View) {
        var TAG = " satta"
        try {

            supportFragmentManager.findFragmentById(R.id.favFragment)?.findNavController().apply {
            navigateUpTo(intent)
        }


// Find the button by ID


// Set an onClickListener for the button
//            view.setOnClickListener {
//                // Navigate to the second fragment
//                navController.navigate(R.id.expFragment)
//            }

        } catch (e: java.lang.Exception) {
            Log.e(TAG, "tast2: ${e.message}")
        }
    }
}




