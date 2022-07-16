package com.example.royalcrowncola

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAdapter.onItemClick = {
            Toast.makeText(this,"Clicked ", Toast.LENGTH_SHORT).show()
        }
        initRecyclerView()
    }


    fun initRecyclerView(){
        val data = DataModel.setData()
        val recyclerView : RecyclerView = findViewById(R.id.item_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        myAdapter = RecyclerAdapter()
        recyclerView.adapter = myAdapter
        myAdapter.setData(data)
    }
}