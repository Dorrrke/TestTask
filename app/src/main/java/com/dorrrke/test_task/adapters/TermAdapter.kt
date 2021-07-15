package com.dorrrke.test_task.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task.MainActivity
import com.dorrrke.test_task.R
import com.dorrrke.test_task.jsonModel.TerminalDb
import java.util.*
import kotlin.collections.ArrayList

class TermAdapter(private val list: ArrayList<TerminalDb>, val fragment: Int) :
    RecyclerView.Adapter<TermAdapter.TerminalViewHolder>(), Filterable{

    var terminalFilterList = ArrayList<TerminalDb>()

    init {
        terminalFilterList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerminalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TerminalViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TerminalViewHolder, position: Int) {
        val term: TerminalDb = terminalFilterList[position]
        holder.bind(term)
        holder.terminalName?.setOnClickListener {
            val back = Intent(holder.itemView.context, MainActivity::class.java)
            if (fragment == 1)
            {
                back.putExtra("fromName", term)
            }
            else
            {
                back.putExtra("toName", term)
            }
            holder.itemView.context.startActivity(back)
        }
        holder.teminalAdres?.setOnClickListener {
            val back = Intent(holder.itemView.context, MainActivity::class.java)
            if (fragment == 1)
            {
                back.putExtra("fromName", term)
            }
            else
            {
                back.putExtra("toName", term)
            }
            holder.itemView.context.startActivity(back)
        }
        holder.map?.setOnClickListener {
            val back = Intent(holder.itemView.context, MainActivity::class.java)
            if (fragment == 1)
            {
                back.putExtra("fromName", term)
            }
            else
            {
                back.putExtra("toName", term)
            }
            holder.itemView.context.startActivity(back)
        }
        holder.worktable?.setOnClickListener {
            val back = Intent(holder.itemView.context, MainActivity::class.java)
            if (fragment == 1)
            {
                back.putExtra("fromName", term)
            }
            else
            {
                back.putExtra("toName", term)
            }
            holder.itemView.context.startActivity(back)
        }
    }

    override fun getItemCount(): Int = terminalFilterList.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    terminalFilterList = list
                } else {
                    val resultList = ArrayList<TerminalDb>()
                    for (row in list) {
                        if (row.name.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    terminalFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = terminalFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                terminalFilterList = results?.values as ArrayList<TerminalDb>
                notifyDataSetChanged()
            }

        }
    }


    inner class TerminalViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.recycler_items, parent, false
        )
    ) {

        var terminalName: TextView?  = null
        var teminalAdres: TextView? = null
        var worktable: TextView? = null
        var map: ImageView? = null


        init {
            terminalName = itemView.findViewById(R.id.NameT)
            teminalAdres = itemView.findViewById(R.id.Adress)
            worktable = itemView.findViewById(R.id.workTable)
            map = itemView.findViewById(R.id.map)
        }

        fun bind(terminal: TerminalDb) {
            terminalName?.text = "Терминал: " + terminal.name
            teminalAdres?.text = "Адресс: " + terminal.address
            var table: String = "Расписание: "
            for (el in terminal.worktables) {
                var str = el.department + "\n"
                str += el.timetable + "\n" + "\n"

                table += str
            }
            worktable?.text = table
        }



        }
    }



//
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                var charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    terminalFilterList = list
//                } else {
//                    var resultList = ArrayList<TerminalDb>()
//                    for (row in list) {
//                        if (row.name.lowercase()
//                                .contains(charSearch.lowercase())
//                        ) {
//                            resultList.add(row)
//                        }
//                    }
//                    terminalFilterList = resultList
//                }
//                var filterResult: FilterResults = FilterResults()
//                filterResult.values = terminalFilterList
//                return filterResult
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                terminalFilterList = results?.values as ArrayList<TerminalDb>
//                notifyDataSetChanged()
//            }
//
//        }
//    }


