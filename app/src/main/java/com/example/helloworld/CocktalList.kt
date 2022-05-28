package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
 val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = CustomRecyclerAdapter(fillList())
private fun fillList():List<String>{
    val data = mutableListOf<String>()
    (0..30).forEach{ i -> data.add("$i element") }
    return data*/

class CocktalList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}

