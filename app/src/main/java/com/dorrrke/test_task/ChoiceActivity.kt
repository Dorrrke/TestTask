package com.dorrrke.test_task


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task.adapters.PagerAdapter
import com.dorrrke.test_task.databinding.ChoiceActivityBinding
import com.dorrrke.test_task.databinding.ChoiceActivityBindingImpl
import com.dorrrke.test_task.databinding.FragmentFirstBinding
import com.dorrrke.test_task.db.dbManeger
import com.dorrrke.test_task.jsonModel.TerminalDb
import com.google.android.material.tabs.TabLayoutMediator


class ChoiceActivity : AppCompatActivity() {
    val dbManeger = dbManeger(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ChoiceActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.choice_activity)
        binding.tabs.setSelectedTabIndicatorColor(Color.WHITE)
        binding.tabs.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        binding.tabs.tabTextColors =
            ContextCompat.getColorStateList(this, R.color.selectedTabTextColor)
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
            }
        }.attach()

    }
}