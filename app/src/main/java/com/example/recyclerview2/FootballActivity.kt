package com.example.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.adapter.FootballAdapter
import com.example.recyclerview2.model.Football
import com.google.android.material.button.MaterialButton

class FootballActivity : AppCompatActivity() {
    private val footballAdapter by lazy { FootballAdapter() }
    private lateinit var recyclerView: RecyclerView
    private lateinit var addBtn: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)
        recyclerView = findViewById(R.id.recyclerView)
        addBtn = findViewById(R.id.button)
        with(recyclerView) {
            layoutManager = GridLayoutManager(this@FootballActivity, 3)
            adapter = footballAdapter
        }
        addBtn.setOnClickListener {
            footballAdapter.addClub(randomClub())
        }
        footballAdapter.onClick = { football, pos ->
            footballAdapter.footballClubList.removeAt(pos)
            footballAdapter.notifyItemRemoved(pos)
        }
    }
    private fun randomClub(): Football {
        val list = listOf(
            Football(
                "Tottenham",
                R.drawable.img_4
            ),
            Football(
                "Barsa",
                R.drawable.img_5
            ),
            Football(
                "Chelsea",
                R.drawable.img_6
            ),
            Football(
                "Liverpool",
                R.drawable.img_7
            ),
            Football(
                "Man City",
                R.drawable.img_8
            ),
            Football(
                "PSG",
                R.drawable.img_9
            ),
            Football(
                "Real",
                R.drawable.img_10
            )
        )
        return list.random()
    }
}