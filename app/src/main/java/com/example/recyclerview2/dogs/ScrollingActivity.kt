package com.example.recyclerview2.dogs

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview2.R
import com.example.recyclerview2.databinding.ActivityScrollingBinding
import com.example.recyclerview2.model.Animal

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val animal = intent.getSerializableExtra("animal") as Animal
        binding.imageView.setImageResource(animal.image)

    }
}