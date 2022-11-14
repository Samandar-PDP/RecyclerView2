package com.example.recyclerview2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.AnimalLayoutBinding
import com.example.recyclerview2.model.Animal

class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    lateinit var onClick: (Animal) -> Unit

    private val diffCallback = object : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.nickName == newItem.nickName
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var animals: MutableList<Animal>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(AnimalLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])
    }

    override fun getItemCount(): Int = animals.size

    inner class AnimalViewHolder(private val binding: AnimalLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            with(binding) {
                imageView.setImageResource(animal.image)
                textName.text = animal.nickName
                textGender.text = if (animal.gender) "Boy" else "Girl"
            }
            itemView.setOnClickListener {
                onClick.invoke(animal)
            }
        }
    }
}