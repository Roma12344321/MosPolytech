package com.example.mospolytech.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mospolytech.R
import com.example.mospolytech.databinding.FragmentDirectionListBinding
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.presentation.viewmodel.MainViewModel
import com.example.mospolytech.presentation.adapter.DirectionAdapter
import com.example.mospolytech.presentation.viewmodel.DirectionApp
import com.example.mospolytech.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class DirectionListFragment : Fragment() {

    private lateinit var obj: String

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

    private var _binding: FragmentDirectionListBinding? = null
    private val binding: FragmentDirectionListBinding
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
        _binding = FragmentDirectionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseArgs()
        setUpRecyclerView()
        if (obj == EMPTY) {
            binding.textViewEmpty.visibility = View.VISIBLE
            Toast.makeText(context,"Ничего не было найдено",Toast.LENGTH_SHORT).show()
        }
    }

    private fun launchDetailFragment(direction: Direction){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailActivityFragment.newInstance(direction))
            .addToBackStack(null)
            .commit()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewDirection.adapter = directionAdapter
        binding.recyclerViewDirection.itemAnimator = null
        viewModel.allFavouriteDirection.observe(viewLifecycleOwner) {
            directionAdapter.submitList(it.filter { it.objects == obj })
        }
        setUpCkickListeners()
    }

    private fun setUpCkickListeners() {
        directionAdapter.onItemClickListener = object : DirectionAdapter.OnItemClickListener {
            override fun onItemClick(direction: Direction) {
                launchDetailFragment(direction)
            }
        }
        directionAdapter.onStarClickListener = object : DirectionAdapter.OnStarClickListener {
            override fun onStarClick(direction: Direction) {
                viewModel.changeFavouriteState(direction)
            }
        }
    }

    private fun parseArgs() {
        requireArguments().getString(OBJECT_KEY)?.let {
            obj = it
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val EMPTY = ""
        const val RUS_MATH_INF = "Русский Математика Информатика"

        private const val OBJECT_KEY = "Русский Математика Информатика"
        fun newInstance(obj:String): DirectionListFragment {
            return DirectionListFragment().apply {
                arguments = Bundle().apply {
                    putString(OBJECT_KEY,obj)
                }
            }
        }
    }
}