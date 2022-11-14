package com.example.recyclerview2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.FoodLayoutBinding
import com.example.recyclerview2.databinding.VerLayoutBinding
import com.example.recyclerview2.list.AnimalList

class VerticalAdapter    : ListAdapter<AnimalList, VerticalAdapter.VerticalViewHolder>(DiffCallBack()) {
    private class DiffCallBack : DiffUtil.ItemCallback<AnimalList>() {
        override fun areItemsTheSame(oldItem: AnimalList, newItem: AnimalList): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: AnimalList, newItem: AnimalList): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewHolder(
            VerLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VerticalViewHolder(private val binding: VerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animalList: AnimalList) {
            binding.apply {
                imageView.setImageResource(animalList.image)
                textName.text = animalList.name
                textCost.text = animalList.cost.toString()
            }
        }
    }
}