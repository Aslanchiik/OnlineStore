package com.example.onlinestore.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.databinding.ItemCategoryBinding
import com.example.onlinestore.extensions.setOnSingleClickListener

class CategoryAdapters(private val onItemClick: (id: String) -> Unit) :
    ListAdapter<String, CategoryAdapters.ViewHolders>(differCallback) {

    inner class ViewHolders(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnSingleClickListener {
                onItemClick(getItem(adapterPosition))
            }
        }

        fun onBind(item: String?) {
            binding.electronicsTxt.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        return ViewHolders(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val differCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}