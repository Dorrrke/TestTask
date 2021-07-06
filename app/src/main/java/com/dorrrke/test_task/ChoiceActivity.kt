package com.dorrrke.test_task

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.dorrrke.test_task.adapters.PagerAdapter
import com.dorrrke.test_task.databinding.ChoiceActivityBinding
import com.google.android.material.tabs.TabLayoutMediator


class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ChoiceActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.choice_activity)

        binding.tabs.setSelectedTabIndicatorColor(Color.WHITE)
        binding.tabs.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        binding.tabs.tabTextColors = ContextCompat.getColorStateList(this, android.R.color.white)

        val adapter = PagerAdapter(supportFragmentManager, lifecycle, 2)
        binding.viewpager.adapter = adapter
        binding.viewpager.isUserInputEnabled = true

        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Откуда"
                }
                1 -> {
                    tab.text = "Куда"

                }
            } }.attach()
    }
}