package com.dorrrke.test_task.fragments


import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task.ChoiceActivity
import com.dorrrke.test_task.MainActivity
import com.dorrrke.test_task.R
import com.dorrrke.test_task.adapters.TermAdapter
import com.dorrrke.test_task.adapters.TerminalClickListener
import com.dorrrke.test_task.db.dbManeger
import com.dorrrke.test_task.jsonModel.TerminalDb

class FirstFragment : Fragment() {

    lateinit var terminals: ArrayList<TerminalDb>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)
        val fragmentName = arguments?.getString("Откуда")

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbManeger = dbManeger(view.context)
        dbManeger.openDb()
        terminals = dbManeger.readDbDataFrom()

        val adapter = TermAdapter(terminals, 1)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_First)



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



//        adapter.onItemClick = {
//            val choice = Intent(view.context, MainActivity::class.java)
//            startActivity(choice)
//        }


//        view.findViewById<androidx.appcompat.widget.SearchView>(R.id.searchView).setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                adapter.filter.filter(newText)
//                return false
//            }
//
//        })
    }

}

