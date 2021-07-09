package com.dorrrke.test_task.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dorrrke.test_task.fragments.FirstFragment
import com.dorrrke.test_task.fragments.SecondFragment

class PagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val bundle = Bundle()
                bundle.putString("firstFragment", "Откуда")
                val musicFragment = FirstFragment()
                musicFragment.arguments = bundle
                return musicFragment
            }
            1 -> {
                val bundle = Bundle()
                bundle.putString("secondFragment", "Куда")
                val moviesFragment = SecondFragment()
                moviesFragment.arguments = bundle
                return moviesFragment
            }
            else -> return FirstFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}