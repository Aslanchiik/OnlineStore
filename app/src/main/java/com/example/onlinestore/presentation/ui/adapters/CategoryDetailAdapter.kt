package com.example.onlinestore.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinestore.base.BaseDiffUtilItemCallback
import com.example.onlinestore.databinding.ItemCategoryDetailBinding
import com.example.onlinestore.extensions.loadImagesWithGlide
import com.example.onlinestore.presentation.models.CategoryModelUI

class CategoryDetailAdapter(val onItemClick: (id: Int) -> Unit) :
    ListAdapter<CategoryModelUI, CategoryDetailAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    inner class ViewHolder(private val binding: ItemCategoryDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(getItem(adapterPosition).id)
            }
        }

        fun onBind(item: CategoryModelUI?) = with(binding) {
            priceItem.text = "${item?.price.toString()}$"
            titleItem.text = item?.title
            item?.image?.let { imageViewItem.loadImagesWithGlide(it, loaderProgressBar) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}