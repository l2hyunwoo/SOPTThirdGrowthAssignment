package com.example.soptthirdgrowthassignment.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.soptthirdgrowthassignment.main.BookFragment
import com.example.soptthirdgrowthassignment.main.HomeFragment
import com.example.soptthirdgrowthassignment.main.MyPageFragment

class MainPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> BookFragment()
            else -> MyPageFragment()
        }
    }

    override fun getCount() = 3
}