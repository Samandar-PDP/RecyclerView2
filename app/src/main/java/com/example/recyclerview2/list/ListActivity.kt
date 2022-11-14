package com.example.recyclerview2.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.R
import com.example.recyclerview2.adapter.AnimalListAdapter
import com.example.recyclerview2.adapter.VerticalAdapter
import com.example.recyclerview2.databinding.ActivityListBinding
import com.example.recyclerview2.util.Constants

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private val animalListAdapter by lazy { AnimalListAdapter() }
    private val verticalAdapter by lazy { VerticalAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = animalListAdapter
            layoutManager = LinearLayoutManager(this@ListActivity, RecyclerView.HORIZONTAL, false)
        }
        binding.recyclerView2.apply {
            adapter = verticalAdapter
            layoutManager = LinearLayoutManager(this@ListActivity)
        }
        animalListAdapter.submitList(Constants.foodList())
        verticalAdapter.submitList(Constants.foodList())
    }
}