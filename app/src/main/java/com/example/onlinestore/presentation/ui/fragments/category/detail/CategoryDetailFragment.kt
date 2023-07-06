package com.example.onlinestore.presentation.ui.fragments.category.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlinestore.R
import com.example.onlinestore.base.BaseFragment
import com.example.onlinestore.databinding.FragmentCategoryDetailBinding
import com.example.onlinestore.presentation.state.UIState
import com.example.onlinestore.presentation.ui.adapters.CategoryDetailAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryDetailFragment :
    BaseFragment<FragmentCategoryDetailBinding, CategoryDetailViewModel>(R.layout.fragment_category_detail) {

    override val binding by viewBinding(FragmentCategoryDetailBinding::bind)
    override val viewModel: CategoryDetailViewModel by viewModels()
    private val args by navArgs<CategoryDetailFragmentArgs>()
    private val categoryDetailAdapter = CategoryDetailAdapter(this::onItemClick)

    private fun onItemClick(i: Int) {
      findNavController().navigate(
          CategoryDetailFragmentDirections.actionCategoryDetailFragmentToProductsFragment(
              i
          )
      )
    }

    override fun initialize() {
        binding.categoryDetailRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryDetailAdapter
        }

        viewModel.fetchCategoryId(args.id, args.sort ?: "")
    }

    override fun setupRequest() {
        viewModel.categoryState.subscribe {
            when (it) {
                is UIState.Error -> Log.e("error", it.error)
                is UIState.Success -> {
                    categoryDetailAdapter.submitList(it.data)
                }

                else -> {}
            }
        }
    }

    override fun setupListeners() {
        binding.sortFloatButton.setOnClickListener {
            findNavController().navigate(
                CategoryDetailFragmentDirections.actionFromDetailCategoryToSortCategoryBottomSheet(
                    args.id
                )
            )
        }
    }
}