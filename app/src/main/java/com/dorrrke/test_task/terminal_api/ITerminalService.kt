package com.dorrrke.test_task.terminal_api

import City
import CityList
import retrofit2.Call
import retrofit2.http.GET

interface ITerminalService {
    @GET("/static/catalog/terminals_v3.json")
    fun getCity(): Call<CityList>
}