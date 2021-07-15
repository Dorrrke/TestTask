package com.dorrrke.test_task.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task.R
import com.dorrrke.test_task.adapters.TermAdapter
import com.dorrrke.test_task.db.dbManeger
import com.dorrrke.test_task.jsonModel.TerminalDb

class SecondFragment : Fragment() {

    lateinit var terminals: ArrayList<TerminalDb>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        val fragmentName = arguments?.getString("Куда")
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbManeger = dbManeger(view.context)
        dbManeger.openDb()
        terminals = dbManeger.readDbDataTo()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerSecond)
        val adapter = TermAdapter(terminals, 2)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(
                DividerItemDecoration(
                    view.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
        recyclerView.adapter = adapter

        val serach = view.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_2)
        serach.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })

    }

}

