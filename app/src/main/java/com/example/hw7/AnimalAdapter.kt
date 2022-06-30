package com.example.hw7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw7.databinding.ItemAnimalBinding

class AnimalAdapter(private val data: ArrayList<Animal>, private val onItemLongClick: OnItemLongClick) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(data.get(position))
        holder.itemView.setOnLongClickListener{
            onItemLongClick.onLongClick(data.get(position))
            true
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class AnimalViewHolder(private val binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(animal: Animal) {
            binding.tvName.text = animal.name
            binding.ivAnimal.loadData(animal.image.toString())
        }

    }
}