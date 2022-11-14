package com.example.recyclerview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview2.adapter.GridAdapter
import com.example.recyclerview2.model.Grid
import com.example.recyclerview2.util.Constants

class MainActivity : AppCompatActivity() {
    private val gridAdapter by lazy { GridAdapter() }
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = gridAdapter
        }
        gridAdapter.gridList = Constants.list.toMutableList()
        gridAdapter.onClick = {
            val bundle = bundleOf("grid" to it)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}