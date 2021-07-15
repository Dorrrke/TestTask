package com.dorrrke.test_task

import CityList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.dorrrke.test_task.databinding.ActivityMainBinding
import com.dorrrke.test_task.db.dbManeger
import com.dorrrke.test_task.jsonModel.Order
import com.dorrrke.test_task.jsonModel.TerminalDb
import com.dorrrke.test_task.terminal_api.ITerminalService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var str: String = ""
    val dbManeger = dbManeger(this)
    lateinit var textFrom: TextView
    lateinit var textTo: TextView
    val ORDER_KEY = "order"


    companion object {
        var order = Order()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        parseJson()

        textFrom = binding.textFrom
        textTo = binding.textTo

        textFrom.setOnClickListener {
            val choice = Intent(this, ChoiceActivity::class.java)
            startActivity(choice)
        }
        textTo.setOnClickListener {
            val choice = Intent(this, ChoiceActivity::class.java)
            startActivity(choice)
        }

        if( intent.getSerializableExtra("fromName") != null)
            order.terminalFrom = intent.getSerializableExtra("fromName") as TerminalDb
        if( intent.getSerializableExtra("toName") != null)
            order.terminalTo = intent.getSerializableExtra("toName") as TerminalDb

        textFrom.text = order.terminalFrom?.name
        textTo.text = order.terminalTo?.name
    }



    fun parseJson() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dellin.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        dbManeger.openDb()
        val api = retrofit.create(ITerminalService::class.java)
        val call = api.getCity()
        call.enqueue(object : Callback<CityList> {
            override fun onResponse(call: Call<CityList>, response: Response<CityList>) {
                val cities = response.body()
                val fullTerminals = cities?.city!![0].terminals.terminal
                val city = cities.city
                var size = fullTerminals.size
                str = fullTerminals[0].name
                var url: String = ""
                dbManeger.clearTerminals()
                dbManeger.clearWorktable()
                var termId = 0
                for (i in city.indices) {
                    for (t in city[i].terminals.terminal.indices) {
                        dbManeger.insertIntoTerminals(city[i].terminals.terminal[t])
                        for (element in city[i].terminals.terminal[t].worktables.worktable) {
                            dbManeger.insertIntoWorktable(
                                element,
                                termId + 1
                            )
                        }
                        termId++
                    }
                }

            }

            override fun onFailure(call: Call<CityList>, t: Throwable) {
                Log.v("Error", t.toString())
            }
        })
    }


}

