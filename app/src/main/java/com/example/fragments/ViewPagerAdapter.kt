package com.example.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle

class ViewPagerAdapter(private val myContext: Context, fm: FragmentManager,var lifecycle: Lifecycle) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return firstFragment()
            }
            1 -> {
                return SecondFragment()
            }
            2 -> {
                // val movieFragment = MovieFragment()
                return ThirdFragment()
            }
            else -> return SecondFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return 3
    }
   
    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
        when(position){
            0->{
                return "First"
            }
            1->{
                return " Second"

            }
            2->{
                return "Third"

            }
            else->{
                return super.getPageTitle(position)
            }
        }
    }
}
