package com.example.onlinestore.presentation.ui.fragments.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.onlinestore.databinding.FragmentSortCategoryBottomSheetBinding
import com.example.onlinestore.extensions.setDropMenu
import com.example.onlinestore.extensions.setOnSingleClickListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SortCategoryDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSortCategoryBottomSheetBinding
    private val args by navArgs<SortCategoryDialogFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortCategoryBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() = with(binding.filterTxt) {
        setOnSingleClickListener {
            setAdapter(setDropMenu())
            showDropDown()
        }
    }

    private fun setupListener() {
        binding.applyButton.setOnClickListener {
            val sort = binding.filterTxt.text.toString()
            findNavController().navigate(
                SortCategoryDialogFragmentDirections.actionSortCategoryBottomSheetFragmentToCategoryDetailFragment(
                    args.id, sort
                )
            )
        }
    }
}