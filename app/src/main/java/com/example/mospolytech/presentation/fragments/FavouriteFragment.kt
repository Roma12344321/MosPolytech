package com.example.mospolytech.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mospolytech.R
import com.example.mospolytech.databinding.FragmentFavouriteBinding
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.presentation.adapter.DirectionAdapter
import com.example.mospolytech.presentation.viewmodel.DirectionApp
import com.example.mospolytech.presentation.viewmodel.MainViewModel
import com.example.mospolytech.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class FavouriteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as DirectionApp).component
    }

    private val adapter by lazy {
        DirectionAdapter()
    }

    private var _binding: FragmentFavouriteBinding? = null
    private val binding: FragmentFavouriteBinding
        get() = _binding ?: throw RuntimeException("FragmentFavouriteBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewFavourite.adapter = adapter
        viewModel.allFavouriteDirection.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            if (it.isEmpty()) {
                binding.textViewNothingInFavourite.visibility = View.VISIBLE
            } else {
                binding.textViewNothingInFavourite.visibility = View.GONE
            }
        }
        adapter.onItemClickListener = object : DirectionAdapter.OnItemClickListener {
            override fun onItemClick(direction: Direction) {
                launchDetailFragment(direction)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchDetailFragment(direction: Direction) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailActivityFragment.newInstance(direction))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance(): FavouriteFragment {
            return FavouriteFragment()
        }
    }
}