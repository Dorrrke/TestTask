package com.dorrrke.test_task

import City
import CityList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.dorrrke.test_task.terminal_api.ITerminalService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    lateinit var testText: TextView
    var str: String = ""
    var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testText = findViewById(R.id.textView)
        parseJson()
    }

    fun parseJson() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.dellin.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api = retrofit.create(ITerminalService::class.java)
        var call = api.getCity()
        call.enqueue(object : Callback<CityList> {
            override fun onResponse(call: Call<CityList>, response: Response<CityList>) {
                var cities = response.body()
                var city = cities?.city
                var size = city!!.size
                str = city[0].name

                testText.text = str
            }

            override fun onFailure(call: Call<CityList>, t: Throwable) {
                Log.v("Error", t.toString())
            }

        })
        }

    }
