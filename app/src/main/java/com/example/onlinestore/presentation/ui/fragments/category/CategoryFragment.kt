package com.example.onlinestore.presentation.ui.fragments.category

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlinestore.R
import com.example.onlinestore.base.BaseFragment
import com.example.onlinestore.databinding.FragmentCategoryBinding
import com.example.onlinestore.presentation.state.UIState
import com.example.onlinestore.presentation.ui.adapters.CategoryAdapters
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment :
    BaseFragment<FragmentCategoryBinding, CategoryViewModel>(R.layout.fragment_category) {

    override val binding by viewBinding(FragmentCategoryBinding::bind)
    override val viewModel: CategoryViewModel by viewModels()
    private val categoryAdapters = CategoryAdapters(this::onItemClick)

    private fun onItemClick(id: String) {
        findNavController().navigate(
            CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailFragment(
                id
            )
        )
    }

    override fun initialize() {
        binding.categoryRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapters
        }
    }

    override fun setupRequest() {
        viewModel.categoriesState.subscribe {
            when (it) {
                is UIState.Error -> Log.e("error", it.error)
                is UIState.Success -> {
                    categoryAdapters.submitList(it.data)
                }

                else -> {}
            }
        }
    }
}