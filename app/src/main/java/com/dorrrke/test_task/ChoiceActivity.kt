package com.dorrrke.test_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dorrrke.test_task.databinding.ActivityMainBinding
import com.dorrrke.test_task.databinding.ChoiceActivityBinding

class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ChoiceActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.choice_activity)
    }
}