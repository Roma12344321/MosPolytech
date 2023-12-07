package com.example.mospolytech.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mospolytech.R
import com.example.mospolytech.databinding.FragmentInfrusmathBinding
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.presentation.viewmodel.MainViewModel
import com.example.mospolytech.presentation.adapter.DirectionAdapter
import com.example.mospolytech.presentation.viewmodel.DirectionApp
import com.example.mospolytech.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class InfMathRusFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    private val directionAdapter by lazy {
        DirectionAdapter()
    }

    private val viewModel by lazy {
        ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as DirectionApp).component
    }

    private var _binding: FragmentInfrusmathBinding? = null
    private val binding: FragmentInfrusmathBinding
        get() = _binding ?: throw RuntimeException("binding = null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfrusmathBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    fun launchDetailFragment(direction: Direction){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailActivityFragment.newInstance(direction))
            .addToBackStack(null)
            .commit()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewDirection.adapter = directionAdapter
        viewModel.getAllDirection().observe(viewLifecycleOwner) {
            directionAdapter.submitList(it)
        }
        directionAdapter.onItemClickListener = object : DirectionAdapter.OnItemClickListener{
            override fun onItemClick(direction: Direction) {
                launchDetailFragment(direction)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): InfMathRusFragment {
            return InfMathRusFragment()
        }
    }
}