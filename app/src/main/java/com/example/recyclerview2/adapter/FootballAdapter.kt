package com.example.recyclerview2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.R
import com.example.recyclerview2.model.Football

class FootballAdapter : RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {

    lateinit var onClick: (Football, pos: Int) -> Unit

    var footballClubList: MutableList<Football> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_layout, parent, false)
        return FootballViewHolder(view)
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bind(footballClubList[position])
    }

    override fun getItemCount(): Int {
        return footballClubList.size
    }

    inner class FootballViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(football: Football) {
            val imageView: ImageView = view.findViewById(R.id.imageView)
            val textView: TextView = view.findViewById(R.id.textView)
            imageView.setImageResource(football.logo)
            textView.text = football.name

            itemView.setOnClickListener {
                onClick.invoke(football, adapterPosition)
            }
        }
    }
    fun addClub(football: Football) {
        footballClubList.add(football)
        notifyDataSetChanged()
    }
}