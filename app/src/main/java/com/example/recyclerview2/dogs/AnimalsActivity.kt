package com.example.recyclerview2.dogs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.R
import com.example.recyclerview2.adapter.AnimalAdapter
import com.example.recyclerview2.databinding.ActivityAnimalsBinding
import com.example.recyclerview2.util.Constants

class AnimalsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAnimalsBinding.inflate(layoutInflater) }
    private val animalAdapter by lazy { AnimalAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AnimalsActivity)
            adapter = animalAdapter
        }
        animalAdapter.animals = Constants.animalList()
        animalAdapter.onClick = {
            val bundle = bundleOf("animal" to it)
            val intent = Intent(this, ScrollingActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}