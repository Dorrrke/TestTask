package com.dorrrke.test_task

import CityList
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import com.dorrrke.test_task.databinding.ActivityMainBinding
import com.dorrrke.test_task.db.dbManeger
import com.dorrrke.test_task.terminal_api.ITerminalService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var str: String = ""
    val dbManeger = dbManeger(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        parseJson()
        binding.textView4.setOnClickListener {
            val choice = Intent(this, ChoiceActivity::class.java)
            startActivity(choice)
        }
        binding.textView5.setOnClickListener {
            val choice = Intent(this, ChoiceActivity::class.java)
            startActivity(choice)
        }
    }

    fun parseJson() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dellin.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        dbManeger.openDb()
        var api = retrofit.create(ITerminalService::class.java)
        var call = api.getCity()
        call.enqueue(object : Callback<CityList> {
            override fun onResponse(call: Call<CityList>, response: Response<CityList>) {
                var cities = response.body()
                var full_terminals = cities?.city!![0].terminals.terminal
                var size = full_terminals.size
                str = full_terminals[0].name
                dbManeger.clearTerminals()
                dbManeger.clearWorktable()
                for (i in 0 until size) {
                    dbManeger.insertIntoTerminals(full_terminals[i])
                    for (t in 0 until full_terminals[i].worktables.worktable.size) {
                        dbManeger.insertIntoWorktable(full_terminals[i].worktables.worktable[t], i+1)
                    }
                }
            }

            override fun onFailure(call: Call<CityList>, t: Throwable) {
                Log.v("Error", t.toString())
            }
        })
    }

}

