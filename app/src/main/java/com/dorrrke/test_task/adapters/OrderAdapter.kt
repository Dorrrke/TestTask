package com.dorrrke.test_task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task.R
import com.dorrrke.test_task.jsonModel.Order

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderHolder>(){

    private var orders: ArrayList<Order> = ArrayList()

    class OrderHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
        R.layout.recycler_items, parent, false
    )) {
        fun bind(order: Order) {
            itemView.findViewById<TextView>(R.id.orderFromName).text = order.terminalFrom?.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapter.OrderHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OrderHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: OrderAdapter.OrderHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount() = orders.size

    fun refreshOreders ( orders : ArrayList<Order>) {
        this.orders = orders
        notifyDataSetChanged()
    }
}