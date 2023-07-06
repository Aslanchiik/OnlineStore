package com.example.onlinestore.presentation.ui.fragments.products

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlinestore.R
import com.example.onlinestore.base.BaseFragment
import com.example.onlinestore.databinding.FragmentProductsBinding
import com.example.onlinestore.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment :
    BaseFragment<FragmentProductsBinding, ProductsViewModel>(R.layout.fragment_products) {

    override val binding by viewBinding(FragmentProductsBinding::bind)
    override val viewModel: ProductsViewModel by viewModels()
    private val args by navArgs<ProductsFragmentArgs>()

    override fun initialize() {
        viewModel.fetchProducts(args.id)
    }

    override fun setupRequest() = with(binding) {
        viewModel.productsState.subscribe {
            when (it) {
                is UIState.Error -> Log.e("prod error", it.error)
                is UIState.Success -> {
                    productTitleTxt.text = it.data.title
                    priceTxt.text = "${it.data.price}$"
                    categoryChooseTxt.text = it.data.category
                    descriptionTxt.text = it.data.description
                    rateTxt.text = it.data.rateModel.rate.toString()
                    Glide.with(productsImage).load(it.data.image).into(productsImage)

                }

                else -> {}
            }
        }
    }
}