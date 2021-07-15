package com.dorrrke.test_task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dorrrke.test_task.jsonModel.Order
import com.dorrrke.test_task.jsonModel.TerminalDb

class MainViewModel : ViewModel() {
    var orderList : MutableLiveData<ArrayList<Order>> = MutableLiveData()

    fun setFromTerminal(teminal : TerminalDb)
    {
        val order = Order()
        order.terminalFrom = teminal
        orderList.value?.add(order)
    }

    fun setToTerminal(teminal : TerminalDb)
    {
        val order = Order()
        order.terminalTo = teminal
        orderList.value?.add(order)
    }

    fun getList() = orderList
}