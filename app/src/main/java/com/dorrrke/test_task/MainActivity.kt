package com.dorrrke.test_task

import CityList
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
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
    var orderList = ArrayList<Order>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        parseJson()
//        var data = dbManeger.readDbData()
//        var str : String = ""
//        for (i in data)
//        {
//            str += i.name + " /n"
//        }
//        binding.textView4.text = str
        binding.textView4.setOnClickListener {
            val choice = Intent(this, ChoiceActivity::class.java)
            startActivity(choice)
        }
        binding.textView5.setOnClickListener {
            val choice = Intent(this, ChoiceActivity::class.java)
            startActivity(choice)
        }
        var order = Order()
        order.terminalFrom = intent.getSerializableExtra("fromName") as TerminalDb?
        order.terminalTo = intent.getSerializableExtra("toName") as TerminalDb?
        orderList.add(order)

        binding.textView4.text = orderList[0].terminalFrom?.name
        binding.textView5.text = orderList[0].terminalTo?.name
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
                var city = cities.city
                var size = full_terminals.size
                str = full_terminals[0].name
                var url : String = ""
                dbManeger.clearTerminals()
                dbManeger.clearWorktable()
                var term_id = 0
                for (i in city.indices) {
                    for (t in city[i].terminals.terminal.indices) {
                        dbManeger.insertIntoTerminals(city[i].terminals.terminal[t])
                        for (element in city[i].terminals.terminal[t].worktables.worktable) {
                            dbManeger.insertIntoWorktable(
                                element,
                                term_id+1
                            )
                        }
                        term_id++
                    }
                }

            }

            override fun onFailure(call: Call<CityList>, t: Throwable) {
                Log.v("Error", t.toString())
            }
        })
//        dbManeger.closeDB()
    }

}

