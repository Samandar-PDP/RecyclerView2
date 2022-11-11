package com.example.recyclerview2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.R
import com.example.recyclerview2.model.Football
import com.example.recyclerview2.model.Grid

class GridAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var gridList: MutableList<Grid> = mutableListOf()
    lateinit var onClick: (Grid) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_layout, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GridViewHolder).bind(gridList[position])
    }

    override fun getItemCount(): Int {
        return gridList.size
    }

    inner class GridViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(grid: Grid) {
            val imageView: ImageView = view.findViewById(R.id.imageView)
            val textView: TextView = view.findViewById(R.id.textView)
            imageView.setImageResource(grid.image)
            textView.text = grid.textName

            itemView.setOnClickListener {
                onClick(grid)
            }
        }
    }
}